package chattyer.web.api;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import chattyer.web.api.models.RoleDto;

public interface RolesApiService {

    ResponseEntity<List<RoleDto>> getRoles(Principal principal, List<UUID> spaceIds, List<UUID> organizationIds, String username);

    ResponseEntity<RoleDto> createRole(RoleDto role);

    ResponseEntity<Void> deleteRole(UUID roleId);

}
