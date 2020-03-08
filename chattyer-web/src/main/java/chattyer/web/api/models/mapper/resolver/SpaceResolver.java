package chattyer.web.api.models.mapper.resolver;

import java.util.UUID;
import java.util.function.Supplier;

import chattyer.web.exceptions.SpaceNotFoundException;
import chattyer.web.messages.Messages;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.Space;
import chattyer.persistence.repositories.SpaceRepository;

@Component
public class SpaceResolver implements Resolver<UUID, Space> {

    private SpaceRepository spaceRepository;

    public SpaceResolver(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    @Override
    public Space resolve(UUID spaceId) {
        return spaceRepository.findById(spaceId)
                              .orElseThrow(getSpaceNotFoundExceptionSupplier(spaceId));
    }

    private Supplier<SpaceNotFoundException> getSpaceNotFoundExceptionSupplier(UUID spaceId) {
        return () -> new SpaceNotFoundException(Messages.SPACE_WITH_ID_0_DOES_NOT_EXIST, spaceId);
    }

}
