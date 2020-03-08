package chattyer.nlp.wit.models;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableApplicationCredentials.class)
@JsonDeserialize(as = ImmutableApplicationCredentials.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ApplicationCredentials {

    @JsonProperty("access_token")
    String getAccessToken();

    @JsonProperty("app_id")
    String getAppId();

}
