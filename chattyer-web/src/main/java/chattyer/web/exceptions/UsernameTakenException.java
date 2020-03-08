package chattyer.web.exceptions;

public class UsernameTakenException extends EntityAlreadyExistsException {

    public UsernameTakenException(String message, Object... args) {
        super(message, args);
    }

    public UsernameTakenException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }

}
