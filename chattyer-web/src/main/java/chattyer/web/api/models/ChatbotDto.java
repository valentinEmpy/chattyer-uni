package chattyer.web.api.models;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableChatbotDto.class)
@JsonDeserialize(as = ImmutableChatbotDto.class)
public interface ChatbotDto {

    @Nullable
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    UUID getId();

    @NotBlank
    @Size(min = 6, max = 30)
    String getName();

    @Nullable
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String getCreatedBy();

    Status getStatus();

    UUID getSpace();

    List<String> getIntents();

    enum Status {
        UNKNOWN, SCHEDULED, TRAINING, READY;
    }

}
