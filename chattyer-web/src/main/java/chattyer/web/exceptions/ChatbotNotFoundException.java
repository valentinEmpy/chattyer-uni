package chattyer.web.exceptions;

import java.text.MessageFormat;

public class ChatbotNotFoundException extends RuntimeException {

    public ChatbotNotFoundException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    public ChatbotNotFoundException(Throwable cause, String message, Object... args) {
        super(MessageFormat.format(message, args), cause);
    }

}
