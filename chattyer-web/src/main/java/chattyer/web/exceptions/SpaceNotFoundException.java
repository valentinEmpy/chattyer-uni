package chattyer.web.exceptions;

public class SpaceNotFoundException extends EntityNotFoundException {

    public SpaceNotFoundException(String message, Object... args) {
        super(message, args);
    }

    public SpaceNotFoundException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }
}
