package chattyer.persistence.models;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "organizations", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    @Column(name = "created_by")
    private String createdBy;

    @OneToMany(mappedBy = "organization", orphanRemoval = true)
    private List<Space> spaces;

    @OneToMany(mappedBy = "scope.organization", orphanRemoval = true)
    private List<Role> roles;

}
