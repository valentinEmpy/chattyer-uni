package chattyer.core.exceptions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationException extends RuntimeException {

    private Set<String> validationErrors = new HashSet<>();

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, List<String> validationErrors) {
        super(message);
        this.validationErrors = new HashSet<>(validationErrors);
    }

    public ValidationException(Throwable cause, String message) {
        super(message, cause);
    }

    public ValidationException addError(String validationError) {
        validationErrors.add(validationError);
        return this;
    }

    public Set<String> getValidationErrors() {
        return validationErrors;
    }

}
