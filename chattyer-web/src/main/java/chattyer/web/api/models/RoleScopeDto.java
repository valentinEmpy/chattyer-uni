package chattyer.web.api.models;

import java.util.UUID;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableRoleScopeDto.class)
@JsonDeserialize(as = ImmutableRoleScopeDto.class)
public interface RoleScopeDto {

    @Nullable
    UUID getOrganizationId();

    @Nullable
    UUID getSpaceId();

}
