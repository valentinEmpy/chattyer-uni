package chattyer.nlp.wit.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@org.immutables.value.Value.Immutable
@JsonSerialize(as = ImmutableEntityValue.class)
@JsonDeserialize(as = ImmutableEntityValue.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ExtendedEntity extends Entity {

    String getLang();

    @JsonProperty("builtin")
    boolean getBuiltIn();

    String getDoc();

    String getId();

    List<Value> getValues();

    @org.immutables.value.Value.Immutable
    @JsonSerialize(as = ImmutableValue.class)
    @JsonDeserialize(as = ImmutableValue.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    interface Value {

        String getValue();

        List<String> getExpressions();

    }

}
