package chattyer.nlp.wit.models;

import java.util.List;
import java.util.Map;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableAnalysedMessage.class)
@JsonDeserialize(as = ImmutableAnalysedMessage.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface AnalysedMessage {

    @JsonProperty("msg_id")
    String getMessageId();

    @JsonProperty("_text")
    String getMessage();

    Map<String, List<EntityValue>> getEntities();

    @Value.Immutable
    @JsonSerialize(as = ImmutableEntityValue.class)
    @JsonDeserialize(as = ImmutableEntityValue.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    interface EntityValue {

        Double getConfidence();

        String getValue();

        @Nullable
        String getType();

    }

}
