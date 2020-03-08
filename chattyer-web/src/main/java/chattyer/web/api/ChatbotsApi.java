package chattyer.web.api;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import chattyer.web.api.models.ChatbotDto;
import chattyer.web.exception.handling.RestApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/chatbots")
public class ChatbotsApi {

    @Autowired
    private ChatbotsApiService delegate;

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ChatbotDto.class)))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ChatbotDto>>
           getChatbots(Principal principal, @RequestParam(value = "ids", required = false) List<UUID> ids,
                       @RequestParam(value = "names", required = false) List<String> names,
                       @RequestParam(value = "organization_ids", required = false) List<UUID> organizationIds,
                       @RequestParam(value = "space_ids", required = false) List<UUID> spaceIds) {
        return delegate.getChatbots(principal, ids, names, organizationIds, spaceIds);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ChatbotDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @PostMapping
    @PreAuthorize("@authChecker.hasSpaceScopeRole(principal, #spaceId, 'DEVELOPER')")
    public ResponseEntity<ChatbotDto> createChatbot(Principal principal,
                                                    @RequestParam("chatbot_descriptor") MultipartFile chatbotDescriptor,
                                                    @RequestParam("space_id") UUID spaceId) {
        return delegate.createChatbot(principal, chatbotDescriptor, spaceId);
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "204", description = "No Content"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @DeleteMapping("/{chatbotId}")
    public ResponseEntity<Void> deleteChatbot(Principal principal, @PathVariable("chatbotId") UUID chatbotId) {
        return delegate.deleteChatbot(principal, chatbotId);
    }

}
