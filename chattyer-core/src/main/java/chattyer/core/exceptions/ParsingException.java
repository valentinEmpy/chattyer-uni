package chattyer.core.exceptions;

import java.text.MessageFormat;

public class ParsingException extends RuntimeException {

    public ParsingException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    public ParsingException(Throwable cause, String message, Object... args) {
        super(MessageFormat.format(message, args), cause);
    }

    public ParsingException(Throwable cause, String message) {
        super(message, cause);
    }

}
