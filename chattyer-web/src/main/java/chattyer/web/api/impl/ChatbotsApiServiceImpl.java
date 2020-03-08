package chattyer.web.api.impl;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import chattyer.web.api.ChatbotsApiService;
import chattyer.web.api.models.ChatbotDto;
import chattyer.web.api.models.mapper.ChatbotMapper;
import chattyer.web.exceptions.ChatbotNotFoundException;
import chattyer.web.exceptions.ResponseException;
import chattyer.web.messages.Messages;
import chattyer.web.util.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import chattyer.common.models.ChatbotDescriptor;
import chattyer.common.models.Response;
import chattyer.core.handlers.WitApplicationTrainer;
import chattyer.core.processors.ChatbotDescriptorYamlParser;
import chattyer.nlp.wit.analyses.ImmutableAnalyseMessageRequest;
import chattyer.nlp.wit.client.WitClient;
import chattyer.nlp.wit.client.apps.ImmutableDeleteApplicationRequest;
import chattyer.nlp.wit.client.apps.ImmutablePostApplicationRequest;
import chattyer.nlp.wit.client.apps.PostApplicationResponse;
import chattyer.nlp.wit.models.AnalysedMessage;
import chattyer.persistence.models.Chatbot;
import chattyer.persistence.models.RoleType;
import chattyer.persistence.models.WitApplication;
import chattyer.persistence.repositories.ChatbotRepository;
import chattyer.web.api.models.mapper.resolver.SpaceResolver;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Component
public class ChatbotsApiServiceImpl implements ChatbotsApiService {

    private WitClient witClient;
    private ChatbotRepository chatbotRepository;
    private ChatbotMapper chatbotMapper;
    private SpaceResolver spaceResolver;

    public ChatbotsApiServiceImpl(WitClient witClient, ChatbotRepository chatbotRepository, ChatbotMapper chatbotMapper,
                                  SpaceResolver spaceResolver) {
        this.witClient = witClient;
        this.chatbotRepository = chatbotRepository;
        this.chatbotMapper = chatbotMapper;
        this.spaceResolver = spaceResolver;
    }

    @Override
    public ResponseEntity<List<ChatbotDto>> getChatbots(Principal principal, List<UUID> ids, List<String> names, List<UUID> organizationIds,
                                                        List<UUID> spaceIds) {
        List<ChatbotDto> visibleChatbots = chatbotRepository.findByIdAndNameAndSpaceIdAndOrgIdAndRoleForUser(ids, names, spaceIds,
                                                                                                             organizationIds,
                                                                                                             principal.getName())
                                                            .stream()
                                                            .map(chatbotMapper::toDTO)
                                                            .collect(Collectors.toList());
        return ResponseEntity.ok(visibleChatbots);
    }

    @Override
    @Transactional
    public ResponseEntity<ChatbotDto> createChatbot(Principal principal, MultipartFile chatbotDescriptorFile, UUID spaceId) {
        String chatbotDescriptorFileText = Utils.getText(chatbotDescriptorFile);
        ChatbotDescriptor chatbotDescriptor = new ChatbotDescriptorYamlParser().parse(chatbotDescriptorFileText);
        WitApplication witApplication = createWitApplication(chatbotDescriptor);
        Chatbot chatbot = buildChatbot(chatbotDescriptor, witApplication, spaceId, principal.getName());
        chatbotRepository.save(chatbot);
        WitApplicationTrainer witApplicationTrainer = new WitApplicationTrainer(witClient, chatbotDescriptor);
        witApplicationTrainer.train(witApplication);
        return ResponseEntity.ok(chatbotMapper.toDTO(chatbot));
    }

    private WitApplication createWitApplication(ChatbotDescriptor chatbotDescriptor) {
        PostApplicationResponse response = witClient.applications()
                                                    .post(ImmutablePostApplicationRequest.builder()
                                                                                         .name(UUID.randomUUID()
                                                                                                   .toString())
                                                                                         .lang(chatbotDescriptor.getLanguage())
                                                                                         .isPrivate(true)
                                                                                         .build());
        return WitApplication.builder()
                             .id(response.getEntity()
                                         .getAppId())
                             .accessToken(response.getEntity()
                                                  .getAccessToken())
                             .build();
    }

    private Chatbot buildChatbot(ChatbotDescriptor chatbotDescriptor, WitApplication witApplication, UUID spaceId, String user) {
        return Chatbot.builder()
                      .name(chatbotDescriptor.getName())
                      .createdBy(user)
                      .space(spaceResolver.resolve(spaceId))
                      .witApplication(witApplication)
                      .responses(chatbotDescriptor.getResponses())
                      .build();
    }

    @Override
    public ResponseEntity<Void> deleteChatbot(Principal principal, UUID chatbotId) {
        Chatbot chatbot = chatbotRepository.findById(chatbotId)
                                           .orElseThrow(() -> new ChatbotNotFoundException(Messages.CHATBOT_WITH_ID_0_NOT_FOUND,
                                                                                           chatbotId));
        boolean userHasAccess = chatbot.getSpace()
                                       .getRoles()
                                       .stream()
                                       .anyMatch(role -> role.getUser()
                                                             .getUsername()
                                                             .equals(principal.getName())
                                           && role.getType()
                                                  .covers(RoleType.DEVELOPER));
        if (!userHasAccess) {
            throw new ChatbotNotFoundException(Messages.CHATBOT_WITH_ID_0_NOT_FOUND, chatbotId);
        }
        witClient.applications()
                 .delete(ImmutableDeleteApplicationRequest.builder()
                                                          .applicationId(chatbot.getWitApplication()
                                                                                .getId())
                                                          .build());
        chatbotRepository.delete(chatbot);
        return ResponseEntity.noContent()
                             .build();
    }

    @Override
    public String processClientMessage(UUID chatbotId, String message, Principal principal) {
        Chatbot chatbot = chatbotRepository.findById(chatbotId)
                                           .orElseThrow(() -> new ChatbotNotFoundException(Messages.CHATBOT_WITH_ID_0_NOT_FOUND,
                                                                                           chatbotId));
        AnalysedMessage analysedMessage = analyse(message, chatbot);
        AnalysedMessage.EntityValue intentEntity = analysedMessage.getEntities()
                                                                  .getOrDefault("intent", Collections.emptyList())
                                                                  .stream()
                                                                  .max(Comparator.comparing(AnalysedMessage.EntityValue::getConfidence))
                                                                  .orElse(null);
        if (intentEntity == null || intentEntity.getConfidence() < 0.6) {
            return Messages.COULD_NOT_UNDERSTAND;
        }
        Response response = getResponseForIntent(intentEntity.getValue(), chatbot);
        if (response == null) {
            return Messages.COULD_UNDERSTAND_BUT_CANNOT_ANSWER;
        }
        return getMessage(response);
    }

    private AnalysedMessage analyse(String message, Chatbot chatbot) {
        return witClient.analyses()
                        .analyse(ImmutableAnalyseMessageRequest.builder()
                                                               .applicationId(chatbot.getWitApplication()
                                                                                     .getId())
                                                               .message(message)
                                                               .build())
                        .getEntity();
    }

    private Response getResponseForIntent(String intent, Chatbot chatbot) {
        return chatbot.getResponses()
                      .stream()
                      .filter(responseTemplate -> responseTemplate.getIntent()
                                                                  .equals(intent))
                      .findFirst()
                      .orElse(null);
    }

    private String getMessage(Response response) {
        switch (response.getType()) {
            case STATIC:
                return response.getValue();
            case HTTP_CALL_GENERATED:
                return getRemoteMessage(response.getValue());
            default:
                throw new IllegalStateException("Could not determine type of response - actual type is " + response.getType());
        }
    }

    private String getRemoteMessage(String url) {
        try {
            OkHttpClient httpClient = new OkHttpClient();
            okhttp3.Response response = httpClient.newCall(new Request.Builder().url(url)
                                                                                .build())
                                                  .execute();
            if (!response.isSuccessful()) {
                throw new ResponseException(Messages.ERROR_COULD_NOT_EXECUTE_REMOTE_CALL, response.code());
            }
            return response.body()
                           .string();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
