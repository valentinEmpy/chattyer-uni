package chattyer.persistence.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import chattyer.persistence.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    List<Role> findByUser_Username(String username);

    List<Role> findByUser_Id(UUID userId);

    @Query("SELECT r FROM Role r WHERE ((COALESCE(:spaceIds, NULL) IS NULL) "
        + "OR r.scope.space.id IN (:spaceIds)) AND r.user.username = :username")
    List<Role> findBySpaceIdAndForUser(List<UUID> spaceIds, String username);

    @Query("SELECT r FROM Role r WHERE ((COALESCE(:orgIds, NULL) IS NULL) "
        + "OR r.scope.organization.id IN (:orgIds)) AND r.user.username = :username")
    List<Role> findByOrgIdAndForUser(List<UUID> orgIds, String username);

}
