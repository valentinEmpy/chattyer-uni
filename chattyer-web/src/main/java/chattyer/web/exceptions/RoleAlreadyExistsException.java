package chattyer.web.exceptions;

public class RoleAlreadyExistsException extends EntityAlreadyExistsException {

    public RoleAlreadyExistsException(String message, Object... args) {
        super(message, args);
    }

    public RoleAlreadyExistsException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }

}
