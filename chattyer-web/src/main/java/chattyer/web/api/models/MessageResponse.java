package chattyer.web.api.models;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableMessageResponse.class)
@JsonDeserialize(as = ImmutableMessageResponse.class)
public interface MessageResponse {

    String getMessage();

}