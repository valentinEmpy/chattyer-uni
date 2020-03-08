package chattyer.web.exception.handling;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

@Value.Immutable
@JsonRootName(value = "error")
public interface RestApiError {

    String getType();

    String getMessage();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<RestApiSubError> getSubErrors();

}
