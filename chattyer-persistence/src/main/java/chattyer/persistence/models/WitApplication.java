package chattyer.persistence.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
public class WitApplication {

    @Column(name = "wit_application_id", nullable = false)
    private String id;

    @Column(name = "wit_application_access_token", nullable = false)
    private String accessToken;

}
