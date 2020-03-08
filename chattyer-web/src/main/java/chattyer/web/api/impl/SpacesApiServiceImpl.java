package chattyer.web.api.impl;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import chattyer.web.api.models.ImmutableSpaceDto;
import chattyer.web.api.models.SpaceDto;
import chattyer.web.api.models.mapper.SpaceMapper;
import chattyer.web.exceptions.SpaceNotFoundException;
import chattyer.web.exceptions.UserNotFoundException;
import chattyer.web.messages.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.Role;
import chattyer.persistence.models.RoleScope;
import chattyer.persistence.models.RoleType;
import chattyer.persistence.models.Space;
import chattyer.persistence.models.User;
import chattyer.persistence.repositories.RoleRepository;
import chattyer.persistence.repositories.SpaceRepository;
import chattyer.persistence.repositories.UserRepository;
import chattyer.web.api.SpacesApiService;

@Component
public class SpacesApiServiceImpl implements SpacesApiService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private SpaceRepository spaceRepository;
    private SpaceMapper spaceMapper;

    @Autowired
    public SpacesApiServiceImpl(UserRepository userRepository, RoleRepository roleRepository, SpaceRepository spaceRepository,
                                SpaceMapper spaceMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.spaceRepository = spaceRepository;
        this.spaceMapper = spaceMapper;
    }

    @Override
    public ResponseEntity<List<SpaceDto>> getSpaces(Principal principal, List<UUID> ids, List<String> names, List<UUID> organizationIds) {
        List<SpaceDto> visibleSpaces = spaceRepository.findByIdAndNameAndOrgIdAndRoleForUser(ids, names, organizationIds,
                                                                                             principal.getName())
                                                      .stream()
                                                      .map(spaceMapper::toDTO)
                                                      .collect(Collectors.toList());
        return ResponseEntity.ok(visibleSpaces);
    }

    @Override
    public ResponseEntity<SpaceDto> getSpace(UUID spaceId) {
        Space space = spaceRepository.findById(spaceId)
                                     .orElseThrow(getSpaceNotFoundExceptionSupplier(spaceId));
        return ResponseEntity.ok(spaceMapper.toDTO(space));
    }

    private Supplier<SpaceNotFoundException> getSpaceNotFoundExceptionSupplier(UUID spaceId) {
        return () -> new SpaceNotFoundException(Messages.SPACE_WITH_ID_0_DOES_NOT_EXIST, spaceId);
    }

    @Override
    public ResponseEntity<SpaceDto> createSpace(Principal principal, SpaceDto spaceDto) {
        SpaceDto persistableSpace = buildPersistableSpace(spaceDto, principal.getName());
        Space space = spaceMapper.toEntity(persistableSpace);
        User user = userRepository.findByUsernameIgnoreCase(principal.getName())
                                  .orElseThrow(getUserNotFoundExceptionSupplier(principal));
        Role role = getRole(user, space, RoleType.ADMIN);
        spaceRepository.save(space);
        roleRepository.save(role);
        return ResponseEntity.ok(spaceMapper.toDTO(space));
    }

    private SpaceDto buildPersistableSpace(SpaceDto spaceDto, String user) {
        return ImmutableSpaceDto.builder()
                                .from(spaceDto)
                                .createdBy(user)
                                .build();
    }

    private Supplier<UserNotFoundException> getUserNotFoundExceptionSupplier(Principal principal) {
        return () -> new UserNotFoundException(Messages.USER_WITH_USERNAME_0_NOT_FOUND, principal.getName());
    }

    private Role getRole(User user, Space space, RoleType roleType) {
        return Role.builder()
                   .user(user)
                   .type(roleType)
                   .scope(RoleScope.builder()
                                   .space(space)
                                   .build())
                   .build();
    }

    @Override
    public ResponseEntity<SpaceDto> updateSpace(UUID spaceId, SpaceDto updatedSpaceDto) {
        Space space = spaceRepository.findById(spaceId)
                                     .orElseThrow(getSpaceNotFoundExceptionSupplier(spaceId));
        if (merge(space, updatedSpaceDto)) {
            spaceRepository.save(space);
        }
        return ResponseEntity.ok(spaceMapper.toDTO(space));
    }

    private boolean merge(Space existingSpace, SpaceDto updatedSpaceDto) {
        if (updatedSpaceDto.getName() != null) {
            existingSpace.setName(updatedSpaceDto.getName());
            return true;
        }
        return false;
    }

    @Override
    public ResponseEntity<Void> deleteSpace(UUID spaceId) {
        try {
            spaceRepository.deleteById(spaceId);
        } catch (EmptyResultDataAccessException e) {
            throw new SpaceNotFoundException(e, Messages.SPACE_WITH_ID_0_DOES_NOT_EXIST, spaceId);
        }
        return ResponseEntity.noContent()
                             .build();
    }
}
