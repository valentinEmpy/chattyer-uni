package chattyer.persistence.exceptions;

import java.text.MessageFormat;

public class ConversionException extends RuntimeException {

    public ConversionException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    public ConversionException(Throwable cause, String message, Object... args) {
        super(MessageFormat.format(message, args), cause);
    }

}
