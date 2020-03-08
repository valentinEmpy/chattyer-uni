package chattyer.nlp.wit.exceptions;

import java.text.MessageFormat;

public class WitRequestException extends RuntimeException {

    public WitRequestException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

}
