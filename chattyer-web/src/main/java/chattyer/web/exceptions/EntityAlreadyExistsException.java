package chattyer.web.exceptions;

import java.text.MessageFormat;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    public EntityAlreadyExistsException(Throwable cause, String message, Object... args) {
        super(MessageFormat.format(message, args), cause);
    }

}
