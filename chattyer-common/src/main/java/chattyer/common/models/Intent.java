package chattyer.common.models;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableIntent.class)
@JsonDeserialize(as = ImmutableIntent.class)
public interface Intent {

    @JsonProperty(required = true)
    String getName();

}
