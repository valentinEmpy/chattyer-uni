package chattyer.web.api.models.mapper;

import java.util.UUID;

import chattyer.web.api.models.ImmutableRoleScopeDto;
import chattyer.web.api.models.RoleScopeDto;
import chattyer.web.api.models.mapper.resolver.OrganizationResolver;
import chattyer.web.api.models.mapper.resolver.SpaceResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.Organization;
import chattyer.persistence.models.RoleScope;
import chattyer.persistence.models.Space;

@Component
public class RoleScopeMapper implements EntityDtoBidirectionalMapper<RoleScope, RoleScopeDto> {

    private OrganizationResolver organizationResolver;
    private SpaceResolver spaceResolver;

    @Autowired
    public RoleScopeMapper(OrganizationResolver organizationResolver, SpaceResolver spaceResolver) {
        this.organizationResolver = organizationResolver;
        this.spaceResolver = spaceResolver;
    }

    @Override
    public RoleScope toEntity(RoleScopeDto roleScopeDto) {
        return RoleScope.builder()
                        .organization(organizationResolver.resolve(roleScopeDto.getOrganizationId()))
                        .space(spaceResolver.resolve(roleScopeDto.getSpaceId()))
                        .build();
    }

    @Override
    public RoleScopeDto toDTO(RoleScope roleScope) {
        return ImmutableRoleScopeDto.builder()
                                    .organizationId(getOrganizationId(roleScope.getOrganization()))
                                    .spaceId(getSpaceId(roleScope.getSpace()))
                                    .build();
    }

    private UUID getOrganizationId(Organization organization) {
        return organization == null ? null : organization.getId();
    }

    private UUID getSpaceId(Space space) {
        return space == null ? null : space.getId();
    }

}
