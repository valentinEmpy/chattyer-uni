package chattyer.web.exceptions;

import java.text.MessageFormat;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    public EntityNotFoundException(Throwable cause, String message, Object... args) {
        super(MessageFormat.format(message, args), cause);
    }

}
