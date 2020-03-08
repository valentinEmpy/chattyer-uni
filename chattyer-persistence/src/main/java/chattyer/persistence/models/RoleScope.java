package chattyer.persistence.models;

import java.util.UUID;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleScope {

    public static final RoleScope EMPTY = new RoleScope();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "space_id")
    private Space space;

    public boolean covers(RoleScope other) {
        UUID organizationId = other.getOrganization() != null ? other.getOrganization()
                                                                     .getId()
            : null;
        UUID spaceId = other.getSpace() != null ? other.getSpace()
                                                       .getId()
            : null;
        return covers(organizationId, spaceId);
    }

    public boolean covers(UUID organizationId, UUID spaceId) {
        if (organization == null && space == null)
            return true;
        if (space != null && space.getId()
                                  .equals(spaceId))
            return true;
        return organization != null && organization.getId()
                                                   .equals(organizationId);
    }

}