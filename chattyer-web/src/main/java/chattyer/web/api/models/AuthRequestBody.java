package chattyer.web.api.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableAuthRequestBody.class)
@JsonDeserialize(as = ImmutableAuthRequestBody.class)
public interface AuthRequestBody {

    @NotBlank
    @Size(min = 6, max = 20)
    String getUsername();

    @NotBlank
    @Size(min = 6, max = 30)
    String getPassword();

}