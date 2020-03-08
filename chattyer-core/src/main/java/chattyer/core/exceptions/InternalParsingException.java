package chattyer.core.exceptions;

import java.text.MessageFormat;

public class InternalParsingException extends RuntimeException {

    public InternalParsingException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    public InternalParsingException(Throwable cause, String message, Object... args) {
        super(MessageFormat.format(message, args), cause);
    }

    public InternalParsingException(Throwable cause, String message) {
        super(message, cause);
    }

}
