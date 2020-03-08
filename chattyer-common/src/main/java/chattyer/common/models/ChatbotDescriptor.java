package chattyer.common.models;

import java.util.List;

import chattyer.common.models.visitors.ChatbotDescriptorVisitor;
import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableChatbotDescriptor.class)
@JsonDeserialize(as = ImmutableChatbotDescriptor.class)
public interface ChatbotDescriptor {

    @JsonProperty(value = "schema-version", required = true)
    SchemaVersion getSchemaVersion();

    @JsonProperty(required = true)
    String getName();

    @Value.Default
    default Language getLanguage() {
        return Language.EN;
    }

    @JsonProperty(required = true)
    List<Intent> getIntents();

    @JsonProperty(required = true)
    List<Sample> getSamples();

    @JsonProperty(required = true)
    List<Response> getResponses();

    default void accept(ChatbotDescriptorVisitor visitor) {
        getIntents().forEach(visitor::visit);
        getSamples().forEach(visitor::visit);
        getResponses().forEach(visitor::visit);
    }

}
