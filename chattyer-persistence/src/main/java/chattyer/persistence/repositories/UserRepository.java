package chattyer.persistence.repositories;

import java.util.Optional;
import java.util.UUID;

import chattyer.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsernameIgnoreCase(String username);

    Boolean existsByUsernameIgnoreCase(String username);

}