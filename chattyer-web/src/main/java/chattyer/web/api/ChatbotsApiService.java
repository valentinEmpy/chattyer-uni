package chattyer.web.api;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import chattyer.web.api.models.ChatbotDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ChatbotsApiService {

    ResponseEntity<List<ChatbotDto>> getChatbots(Principal principal, List<UUID> ids, List<String> names, List<UUID> organizationIds,
                                                 List<UUID> spaceIds);

    String processClientMessage(UUID chatbotId, String message, Principal principal);

    ResponseEntity<ChatbotDto> createChatbot(Principal principal, MultipartFile chatbotDescriptor, UUID spaceId);

    ResponseEntity<Void> deleteChatbot(Principal principal, UUID chatbotId);

}
