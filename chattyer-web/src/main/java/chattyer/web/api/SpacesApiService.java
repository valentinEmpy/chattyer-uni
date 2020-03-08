package chattyer.web.api;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import chattyer.web.api.models.SpaceDto;
import org.springframework.http.ResponseEntity;

public interface SpacesApiService {

    ResponseEntity<List<SpaceDto>> getSpaces(Principal principal, List<UUID> ids, List<String> names, List<UUID> organizationIds);

    ResponseEntity<SpaceDto> getSpace(UUID spaceId);

    ResponseEntity<SpaceDto> createSpace(Principal principal, SpaceDto space);

    ResponseEntity<SpaceDto> updateSpace(UUID spaceId, SpaceDto updatedSpace);

    ResponseEntity<Void> deleteSpace(UUID spaceId);

}
