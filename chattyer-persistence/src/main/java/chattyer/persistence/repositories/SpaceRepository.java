package chattyer.persistence.repositories;

import java.util.List;
import java.util.UUID;

import chattyer.persistence.models.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpaceRepository extends JpaRepository<Space, UUID> {

    @Query("SELECT s FROM Space s JOIN s.roles r ON r.user.username = :username WHERE "
        + "(COALESCE(:names, NULL) IS NULL OR s.name IN (:names)) AND (COALESCE(:ids, NULL) IS NULL OR s.id IN (:ids)) "
        + "AND (COALESCE(:organizationIds, NULL) IS NULL OR s.organization.id IN (:organizationIds))")
    List<Space> findByIdAndNameAndOrgIdAndRoleForUser(List<UUID> ids, List<String> names, List<UUID> organizationIds, String username);

}
