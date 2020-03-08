package chattyer.web.api.models.mapper.resolver;

import java.util.UUID;
import java.util.function.Supplier;

import chattyer.web.exceptions.OrganizationNotFoundException;
import chattyer.web.messages.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.Organization;
import chattyer.persistence.repositories.OrganizationRepository;

@Component
public class OrganizationResolver implements Resolver<UUID, Organization> {

    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationResolver(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization resolve(UUID organizationId) {
        return organizationRepository.findById(organizationId)
                                     .orElseThrow(getOrganizationNotFoundExceptionSupplier(organizationId));
    }

    private Supplier<OrganizationNotFoundException> getOrganizationNotFoundExceptionSupplier(UUID organizationId) {
        return () -> new OrganizationNotFoundException(Messages.ORGANIZATION_WITH_ID_0_DOES_NOT_EXIST, organizationId);
    }

}
