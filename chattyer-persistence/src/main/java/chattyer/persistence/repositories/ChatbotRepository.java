package chattyer.persistence.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import chattyer.persistence.models.Chatbot;

@Repository
public interface ChatbotRepository extends JpaRepository<Chatbot, UUID> {

    @Query("SELECT c FROM Chatbot c JOIN c.space s JOIN s.roles r ON r.user.username = :username WHERE "
        + "(COALESCE(:ids, NULL) IS NULL OR c.id IN (:ids)) AND (COALESCE(:names, NULL) IS NULL OR c.name IN (:names)) "
        + "AND (COALESCE(:spaceIds, NULL) IS NULL OR c.space.id IN (:spaceIds)) AND (COALESCE(:organizationIds, NULL) IS NULL OR c.space.organization.id IN (:organizationIds))")
    List<Chatbot> findByIdAndNameAndSpaceIdAndOrgIdAndRoleForUser(List<UUID> ids, List<String> names, List<UUID> spaceIds,
                                                                  List<UUID> organizationIds, String username);

    Optional<Chatbot> findByWitApplication_Id(String witApplicationId);

}
