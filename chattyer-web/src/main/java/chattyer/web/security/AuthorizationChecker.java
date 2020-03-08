package chattyer.web.security;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.Role;
import chattyer.persistence.models.RoleScope;
import chattyer.persistence.models.RoleType;
import chattyer.persistence.repositories.RoleRepository;

@Component("authChecker")
public class AuthorizationChecker {

    private RoleRepository roleRepository;

    @Autowired
    public AuthorizationChecker(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public boolean hasRole(UserDetails userDetails, RoleType role) {
        String username = userDetails.getUsername();
        List<Role> userRoles = roleRepository.findByUser_Username(username);
        return userRoles.stream()
                        .anyMatch(userRole -> userRole.getType()
                                                      .covers(role));
    }

    public boolean hasSpaceScopeRole(UserDetails userDetails, UUID spaceId, RoleType role) {
        return hasScopeRole(userDetails, null, spaceId, role);
    }

    public boolean hasOrganizationScopeRole(UserDetails userDetails, UUID organizationId, RoleType role) {
        return hasScopeRole(userDetails, organizationId, null, role);
    }

    public boolean hasScopeRole(UserDetails userDetails, UUID organizationId, UUID spaceId, RoleType role) {
        String username = userDetails.getUsername();
        List<Role> userRoles = roleRepository.findByUser_Username(username);
        return userRoles.stream()
                        .anyMatch(userRole -> scopeCoversOrgAndSpace(userRole.getScope(), organizationId, spaceId) && userRole.getType()
                                                                                                                              .covers(role));
    }

    private boolean scopeCoversOrgAndSpace(RoleScope roleScope, UUID organizationId, UUID spaceId) {
        if (roleScope == null) {
            return true;
        }
        return roleScope.covers(organizationId, spaceId);
    }

}
