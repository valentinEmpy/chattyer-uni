package chattyer.web.exceptions;

public class RoleNotFoundException extends EntityNotFoundException {

    public RoleNotFoundException(String message, Object... args) {
        super(message, args);
    }

    public RoleNotFoundException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }
}
