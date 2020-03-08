package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.models.ExtendedEntity;
import chattyer.nlp.wit.models.Response;
import com.fasterxml.jackson.annotation.JsonCreator;

public class GetEntityResponse extends Response<ExtendedEntity> {

    @JsonCreator
    public GetEntityResponse(ExtendedEntity extendedEntity) {
        super(extendedEntity);
    }

}
