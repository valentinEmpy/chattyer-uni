package chattyer.web.exceptions;

public class WitApplicationNotFoundException extends EntityNotFoundException {

    public WitApplicationNotFoundException(String message, Object... args) {
        super(message, args);
    }

    public WitApplicationNotFoundException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }

}
