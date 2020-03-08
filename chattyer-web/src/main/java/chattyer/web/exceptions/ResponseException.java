package chattyer.web.exceptions;

import java.text.MessageFormat;

public class ResponseException extends RuntimeException {

    public ResponseException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    public ResponseException(Throwable cause, String message, Object... args) {
        super(MessageFormat.format(message, args), cause);
    }

}
