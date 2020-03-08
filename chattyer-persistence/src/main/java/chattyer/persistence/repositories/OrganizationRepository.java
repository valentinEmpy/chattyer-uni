package chattyer.persistence.repositories;

import java.util.List;
import java.util.UUID;

import chattyer.persistence.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    @Query("SELECT o FROM Organization o JOIN o.roles r ON r.user.username = :username "
        + "WHERE (COALESCE(:ids, NULL) IS NULL OR o.id IN (:ids)) AND (COALESCE(:names, NULL) IS NULL OR o.name IN (:names))")
    List<Organization> findByIdAndNameAndRoleForUser(List<UUID> ids, List<String> names, String username);

}
