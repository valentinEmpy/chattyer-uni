package chattyer.nlp.wit.models;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableApplication.class)
@JsonDeserialize(as = ImmutableApplication.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Application {

    String getName();

    String getId();

    @Nullable
    String getDescription();

    @Nullable
    String getLang();

    @JsonProperty("private")
    @Nullable
    Boolean getIsPrivate();

    @JsonProperty("last_training_duration_secs")
    @Nullable
    Integer getLastTrainingDurationSecs();

    @JsonProperty("training_status")
    @Nullable
    String getTrainingStatus();

    default boolean isTraining() {
        return !getTrainingStatus().equalsIgnoreCase("done");
    }

}
