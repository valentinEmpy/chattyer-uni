package chattyer.nlp.wit.models;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableSample.class)
@JsonDeserialize(as = ImmutableSample.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Sample {

    String getText();

    List<EntityWithValue> getEntities();

    @Value.Immutable
    @JsonSerialize(as = ImmutableEntityWithValue.class)
    @JsonDeserialize(as = ImmutableEntityWithValue.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    interface EntityWithValue {

        @JsonIgnore
        Entity getEntity();

        String getValue();

        @Nullable
        Integer getStart();

        @Nullable
        Integer getEnd();

        @JsonProperty("subentities")
        List<EntityWithValue> getSubEntities();

        @JsonProperty("entity")
        default String getEntityName() {
            return getEntity().getName();
        }

    }

}
