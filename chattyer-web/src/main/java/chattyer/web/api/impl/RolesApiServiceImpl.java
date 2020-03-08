package chattyer.web.api.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import chattyer.web.exceptions.RoleAlreadyExistsException;
import chattyer.web.messages.Messages;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.Role;
import chattyer.persistence.repositories.RoleRepository;
import chattyer.web.api.RolesApiService;
import chattyer.web.api.models.RoleDto;
import chattyer.web.api.models.mapper.RoleMapper;
import chattyer.web.exceptions.RoleNotFoundException;

@Component
public class RolesApiServiceImpl implements RolesApiService {

    private RoleRepository roleRepository;
    private RoleMapper roleMapper;

    @Autowired
    public RolesApiServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseEntity<List<RoleDto>> getRoles(Principal principal, List<UUID> spaceIds, List<UUID> organizationIds, String username) {
        List<Role> rolesForSpaces = roleRepository.findBySpaceIdAndForUser(spaceIds, username);
        List<Role> rolesForOrgs = roleRepository.findByOrgIdAndForUser(organizationIds, username);
        Set<RoleDto> roles = ListUtils.union(rolesForSpaces, rolesForOrgs)
                                      .stream()
                                      .map(roleMapper::toDTO)
                                      .collect(Collectors.toSet());
        return ResponseEntity.ok(new ArrayList<>(roles));
    }

    @Override
    public ResponseEntity<RoleDto> createRole(RoleDto role) {
        List<Role> existingRoles = roleRepository.findByUser_Id(role.getUser());
        if (hasConflictingRole(existingRoles, role)) {
            throw new RoleAlreadyExistsException(Messages.ROLE_COVERING_THIS_ACCESS_PERMISSIONS_ALREADY_EXISTS);
        }
        Role roleToSave = roleMapper.toEntity(role);
        roleRepository.save(roleToSave);
        return ResponseEntity.ok(roleMapper.toDTO(roleToSave));
    }

    private boolean hasConflictingRole(List<Role> existingRoles, RoleDto role) {
        UUID organizationId = getOrganizationId(role);
        UUID spaceId = getSpaceId(role);
        return existingRoles.stream()
                            .anyMatch(existingRole -> existingRole.getType()
                                                                  .covers(role.getRole())
                                && existingRole.getScope()
                                               .covers(organizationId, spaceId));
    }

    private UUID getOrganizationId(RoleDto role) {
        return role.getScope() != null ? role.getScope()
                                             .getOrganizationId()
            : null;
    }

    private UUID getSpaceId(RoleDto role) {
        return role.getScope() != null ? role.getScope()
                                             .getSpaceId()
            : null;
    }

    @Override
    public ResponseEntity<Void> deleteRole(UUID roleId) {
        try {
            roleRepository.deleteById(roleId);
        } catch (EmptyResultDataAccessException e) {
            throw new RoleNotFoundException(e, Messages.ROLE_WITH_ID_0_DOES_NOT_EXIST, roleId);
        }
        return ResponseEntity.noContent()
                             .build();
    }

}
