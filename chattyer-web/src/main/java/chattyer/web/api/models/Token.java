package chattyer.web.api.models;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableToken.class)
@JsonDeserialize(as = ImmutableToken.class)
public interface Token {

    String getAccessToken();

    @Value.Default
    default String getTokenType() {
        return "Bearer";
    }

}