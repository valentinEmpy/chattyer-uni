package chattyer.common.models;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableResponse.class)
@JsonDeserialize(as = ImmutableResponse.class)
public interface Response {

    @JsonProperty(required = true)
    Type getType();

    @JsonProperty(required = true)
    String getIntent();

    @JsonProperty(required = true)
    String getValue();

    enum Type {
        @JsonProperty("static")
        STATIC, @JsonProperty("http_call_generated")
        HTTP_CALL_GENERATED;
    }

}
