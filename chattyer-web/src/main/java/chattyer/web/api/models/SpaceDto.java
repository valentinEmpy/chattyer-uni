package chattyer.web.api.models;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableSpaceDto.class)
@JsonDeserialize(as = ImmutableSpaceDto.class)
public interface SpaceDto {

    @Nullable
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    UUID getId();

    @NotBlank
    @Size(min = 6, max = 30)
    String getName();

    @Nullable
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String getCreatedBy();

    UUID getOrganization();

}
