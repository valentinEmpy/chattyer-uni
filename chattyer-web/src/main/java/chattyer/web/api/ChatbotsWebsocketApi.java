package chattyer.web.api;

import java.security.Principal;
import java.util.UUID;

import chattyer.web.websocket.WebSocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class ChatbotsWebsocketApi {

    @Autowired
    private ChatbotsApiService delegate;

    @MessageMapping("/api/websocket/chatbots/{chatbotId}/reply")
    @SendToUser("/queue/reply")
    public String processClientMessage(@DestinationVariable UUID chatbotId, @Payload WebSocketMessage message, Principal principal) {
        return delegate.processClientMessage(chatbotId, message.getText(), principal);
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }

}
