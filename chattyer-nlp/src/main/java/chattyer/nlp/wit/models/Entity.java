package chattyer.nlp.wit.models;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableEntity.class)
@JsonDeserialize(as = ImmutableEntity.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Entity {

    String getName();

}
