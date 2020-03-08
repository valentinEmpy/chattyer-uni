package chattyer.web.api.models.mapper;

import chattyer.web.api.models.ImmutableRoleDto;
import chattyer.web.api.models.mapper.resolver.UserResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.Role;
import chattyer.web.api.models.RoleDto;

@Component
public class RoleMapper implements EntityDtoBidirectionalMapper<Role, RoleDto> {

    private UserResolver userResolver;
    private RoleScopeMapper roleScopeMapper;

    @Autowired
    public RoleMapper(UserResolver userResolver, RoleScopeMapper roleScopeMapper) {
        this.userResolver = userResolver;
        this.roleScopeMapper = roleScopeMapper;
    }

    @Override
    public Role toEntity(RoleDto roleDto) {
        return Role.builder()
                   .user(userResolver.resolve(roleDto.getUser()))
                   .type(roleDto.getRole())
                   .scope(roleScopeMapper.toEntity(roleDto.getScope()))
                   .build();
    }

    @Override
    public RoleDto toDTO(Role role) {
        return ImmutableRoleDto.builder()
                               .user(role.getUser()
                                         .getId())
                               .role(role.getType())
                               .scope(roleScopeMapper.toDTO(role.getScope()))
                               .build();
    }
}
