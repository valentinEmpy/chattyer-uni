package chattyer.web.api.models;

import java.util.UUID;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.Nullable;

import chattyer.persistence.models.RoleType;

@Value.Immutable
@JsonSerialize(as = ImmutableRoleDto.class)
@JsonDeserialize(as = ImmutableRoleDto.class)
public interface RoleDto {

    UUID getUser();

    RoleType getRole();

    @Nullable
    RoleScopeDto getScope();

}
