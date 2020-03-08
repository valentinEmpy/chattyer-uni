package chattyer.web.api.models.mapper;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chattyer.common.models.Response;
import chattyer.nlp.wit.client.WitClient;
import chattyer.nlp.wit.client.apps.ImmutableGetApplicationRequest;
import chattyer.persistence.models.Chatbot;
import chattyer.persistence.models.Space;
import chattyer.web.api.models.ChatbotDto;
import chattyer.web.api.models.ImmutableChatbotDto;
import chattyer.web.api.models.mapper.resolver.SpaceResolver;

@Component
public class ChatbotMapper implements EntityDtoBidirectionalMapper<Chatbot, ChatbotDto> {

    private SpaceResolver spaceResolver;
    private WitClient witClient;

    @Autowired
    public ChatbotMapper(SpaceResolver spaceResolver, WitClient witClient) {
        this.spaceResolver = spaceResolver;
        this.witClient = witClient;
    }

    @Override
    public Chatbot toEntity(ChatbotDto chatbotDto) {
        Space space = spaceResolver.resolve(chatbotDto.getSpace());
        return Chatbot.builder()
                      .name(chatbotDto.getName())
                      .createdBy(chatbotDto.getCreatedBy())
                      .space(space)
                      .build();
    }

    @Override
    public ChatbotDto toDTO(Chatbot chatbot) {
        String trainingStatus = witClient.applications()
                                         .get(ImmutableGetApplicationRequest.builder()
                                                                            .applicationId(chatbot.getWitApplication()
                                                                                                  .getId())
                                                                            .build())
                                         .getEntity()
                                         .getTrainingStatus();
        return ImmutableChatbotDto.builder()
                                  .id(chatbot.getId())
                                  .name(chatbot.getName())
                                  .status(getStatus(trainingStatus))
                                  .createdBy(chatbot.getCreatedBy())
                                  .space(chatbot.getSpace()
                                                .getId())
                                  .addAllIntents(chatbot.getResponses()
                                                        .stream()
                                                        .map(Response::getIntent)
                                                        .collect(Collectors.toList()))
                                  .build();
    }

    private ChatbotDto.Status getStatus(String trainingStatus) {
        if (trainingStatus.equalsIgnoreCase("done")) {
            return ChatbotDto.Status.READY;
        }
        if (trainingStatus.equalsIgnoreCase("scheduled")) {
            return ChatbotDto.Status.SCHEDULED;
        }
        if (trainingStatus.equalsIgnoreCase("ongoing")) {
            return ChatbotDto.Status.TRAINING;
        }
        return ChatbotDto.Status.UNKNOWN;
    }
}
