package chattyer.web.api.models.mapper;

import chattyer.web.api.models.ImmutableOrganizationDto;
import chattyer.web.api.models.OrganizationDto;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.Organization;

@Component
public class OrganizationMapper implements EntityDtoBidirectionalMapper<Organization, OrganizationDto> {

    @Override
    public Organization toEntity(OrganizationDto organizationDto) {
        return Organization.builder()
                           .name(organizationDto.getName())
                           .createdBy(organizationDto.getCreatedBy())
                           .build();
    }

    @Override
    public OrganizationDto toDTO(Organization organization) {
        return ImmutableOrganizationDto.builder()
                                       .id(organization.getId())
                                       .name(organization.getName())
                                       .createdBy(organization.getCreatedBy())
                                       .build();
    }

}
