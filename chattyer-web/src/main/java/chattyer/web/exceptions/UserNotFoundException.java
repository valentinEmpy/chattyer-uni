package chattyer.web.exceptions;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(String message, Object... args) {
        super(message, args);
    }

    public UserNotFoundException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }

}
