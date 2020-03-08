package chattyer.web.exception.handling;

import org.immutables.value.Value;

@Value.Immutable
public interface RestApiSchemaValidationError extends RestApiSubError {

    String getMessage();

}
