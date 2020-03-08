package chattyer.web.exceptions;

public class OrganizationNotFoundException extends EntityNotFoundException {

    public OrganizationNotFoundException(String message, Object... args) {
        super(message, args);
    }

    public OrganizationNotFoundException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }
}
