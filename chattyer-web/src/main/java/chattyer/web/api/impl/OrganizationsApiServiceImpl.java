package chattyer.web.api.impl;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.Organization;
import chattyer.persistence.models.Role;
import chattyer.persistence.models.RoleScope;
import chattyer.persistence.models.RoleType;
import chattyer.persistence.models.User;
import chattyer.persistence.repositories.OrganizationRepository;
import chattyer.persistence.repositories.RoleRepository;
import chattyer.persistence.repositories.UserRepository;
import chattyer.web.api.OrganizationsApiService;
import chattyer.web.api.models.ImmutableOrganizationDto;
import chattyer.web.api.models.OrganizationDto;
import chattyer.web.api.models.mapper.OrganizationMapper;
import chattyer.web.exceptions.OrganizationNotFoundException;
import chattyer.web.exceptions.UserNotFoundException;
import chattyer.web.messages.Messages;

@Component
public class OrganizationsApiServiceImpl implements OrganizationsApiService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private OrganizationRepository organizationRepository;
    private OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationsApiServiceImpl(OrganizationRepository organizationRepository, UserRepository userRepository,
                                       RoleRepository roleRepository, OrganizationMapper organizationMapper) {
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.organizationMapper = organizationMapper;
    }

    @Override
    @Transactional
    public ResponseEntity<List<OrganizationDto>> getOrganizations(Principal principal, List<UUID> ids, List<String> names) {
        List<OrganizationDto> visibleOrganizations = organizationRepository.findByIdAndNameAndRoleForUser(ids, names, principal.getName())
                                                                           .stream()
                                                                           .map(organizationMapper::toDTO)
                                                                           .collect(Collectors.toList());
        return ResponseEntity.ok(visibleOrganizations);
    }

    @Override
    @Transactional
    public ResponseEntity<OrganizationDto> getOrganization(UUID organizationId) {
        Organization organization = organizationRepository.findById(organizationId)
                                                          .orElseThrow(getOrganizationNotFoundExceptionSupplier(organizationId));
        return ResponseEntity.ok(organizationMapper.toDTO(organization));
    }

    private Supplier<OrganizationNotFoundException> getOrganizationNotFoundExceptionSupplier(UUID organizationId) {
        return () -> new OrganizationNotFoundException(Messages.ORGANIZATION_WITH_ID_0_DOES_NOT_EXIST, organizationId);
    }

    @Override
    @Transactional
    public ResponseEntity<OrganizationDto> createOrganization(Principal principal, OrganizationDto organizationDto) {
        OrganizationDto persistableOrganization = buildPersistableOrganization(organizationDto, principal.getName());
        Organization organization = organizationMapper.toEntity(persistableOrganization);
        User user = userRepository.findByUsernameIgnoreCase(principal.getName())
                                  .orElseThrow(getUserNotFoundExceptionSupplier(principal));
        Role role = getRole(user, organization, RoleType.ADMIN);
        organizationRepository.save(organization);
        roleRepository.save(role);
        return ResponseEntity.ok(organizationMapper.toDTO(organization));
    }

    private OrganizationDto buildPersistableOrganization(OrganizationDto organizationDto, String user) {
        return ImmutableOrganizationDto.builder()
                                       .from(organizationDto)
                                       .createdBy(user)
                                       .build();
    }

    private Supplier<UserNotFoundException> getUserNotFoundExceptionSupplier(Principal principal) {
        return () -> new UserNotFoundException(Messages.USER_WITH_USERNAME_0_NOT_FOUND, principal.getName());
    }

    private Role getRole(User user, Organization organization, RoleType roleType) {
        return Role.builder()
                   .user(user)
                   .type(roleType)
                   .scope(RoleScope.builder()
                                   .organization(organization)
                                   .build())
                   .build();
    }

    @Override
    @Transactional
    public ResponseEntity<OrganizationDto> updateOrganization(UUID organizationId, OrganizationDto updatedOrganizationDto) {
        Organization organization = organizationRepository.findById(organizationId)
                                                          .orElseThrow(getOrganizationNotFoundExceptionSupplier(organizationId));
        if (merge(organization, updatedOrganizationDto)) {
            organizationRepository.save(organization);
        }
        return ResponseEntity.ok(organizationMapper.toDTO(organization));
    }

    private boolean merge(Organization existingOrganization, OrganizationDto updatedOrganizationDto) {
        if (updatedOrganizationDto.getName() != null) {
            existingOrganization.setName(updatedOrganizationDto.getName());
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleteOrganization(UUID organizationId) {
        try {
            organizationRepository.deleteById(organizationId);
        } catch (EmptyResultDataAccessException e) {
            throw new OrganizationNotFoundException(e, Messages.ORGANIZATION_WITH_ID_0_DOES_NOT_EXIST, organizationId);
        }
        return ResponseEntity.noContent()
                             .build();
    }

}
