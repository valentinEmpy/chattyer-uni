package chattyer.web.api.models.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.Organization;
import chattyer.persistence.models.Space;
import chattyer.web.api.models.ImmutableSpaceDto;
import chattyer.web.api.models.SpaceDto;
import chattyer.web.api.models.mapper.resolver.OrganizationResolver;

@Component
public class SpaceMapper implements EntityDtoBidirectionalMapper<Space, SpaceDto> {

    private OrganizationResolver organizationResolver;

    @Autowired
    public SpaceMapper(OrganizationResolver organizationResolver) {
        this.organizationResolver = organizationResolver;
    }

    @Override
    public Space toEntity(SpaceDto spaceDto) {
        Organization organization = organizationResolver.resolve(spaceDto.getOrganization());
        return Space.builder()
                    .name(spaceDto.getName())
                    .createdBy(spaceDto.getCreatedBy())
                    .organization(organization)
                    .build();
    }

    @Override
    public SpaceDto toDTO(Space space) {
        return ImmutableSpaceDto.builder()
                                .id(space.getId())
                                .name(space.getName())
                                .createdBy(space.getCreatedBy())
                                .organization(space.getOrganization()
                                                   .getId())
                                .build();
    }

}
