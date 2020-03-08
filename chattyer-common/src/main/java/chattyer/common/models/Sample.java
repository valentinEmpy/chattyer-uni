package chattyer.common.models;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableSample.class)
@JsonDeserialize(as = ImmutableSample.class)
public interface Sample {

    @JsonProperty(required = true)
    String getText();

    @JsonProperty(required = true)
    String getIntent();

    List<MetadataEntity> getMetadata();

    @Value.Immutable
    @JsonSerialize(as = ImmutableMetadataEntity.class)
    @JsonDeserialize(as = ImmutableMetadataEntity.class)
    interface MetadataEntity {

        @JsonProperty(required = true)
        Type getType();

        @JsonProperty(required = true)
        String getValue();

        enum Type {
            @JsonProperty("location")
            LOCATION, @JsonProperty("datetime")
            DATETIME;
        }

    }

}
