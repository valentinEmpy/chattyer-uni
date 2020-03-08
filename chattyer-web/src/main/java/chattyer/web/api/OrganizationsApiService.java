package chattyer.web.api;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import chattyer.web.api.models.OrganizationDto;

public interface OrganizationsApiService {

    ResponseEntity<List<OrganizationDto>> getOrganizations(Principal principal, List<UUID> ids, List<String> names);

    ResponseEntity<OrganizationDto> getOrganization(UUID organizationId);

    ResponseEntity<OrganizationDto> createOrganization(Principal principal, OrganizationDto organization);

    ResponseEntity<OrganizationDto> updateOrganization(UUID organizationId, OrganizationDto updatedOrganization);

    ResponseEntity<Void> deleteOrganization(UUID organizationId);

}
