package chattyer.web.api.models.mapper.resolver;

import java.util.UUID;
import java.util.function.Supplier;

import chattyer.web.exceptions.UserNotFoundException;
import chattyer.web.messages.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.User;
import chattyer.persistence.repositories.UserRepository;

@Component
public class UserResolver implements Resolver<UUID, User> {

    private UserRepository userRepository;

    @Autowired
    public UserResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User resolve(UUID userId) {
        return userRepository.findById(userId)
                             .orElseThrow(getUserNotFoundExceptionSupplier(userId));
    }

    private Supplier<UserNotFoundException> getUserNotFoundExceptionSupplier(UUID userId) {
        return () -> new UserNotFoundException(Messages.USER_WITH_USERNAME_0_NOT_FOUND, userId);
    }

}
