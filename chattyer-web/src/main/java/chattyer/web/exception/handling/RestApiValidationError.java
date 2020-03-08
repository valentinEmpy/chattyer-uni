package chattyer.web.exception.handling;

import org.immutables.value.Value;

@Value.Immutable
public interface RestApiValidationError extends RestApiSubError {

    String getField();

    Object getValue();

    String getMessage();

}
