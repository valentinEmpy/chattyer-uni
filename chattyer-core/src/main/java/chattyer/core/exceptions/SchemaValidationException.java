package chattyer.core.exceptions;

public class SchemaValidationException extends ValidationException {

    public SchemaValidationException(String message) {
        super(message);
    }

    public SchemaValidationException(Throwable cause, String message) {
        super(cause, message);
    }

}
