package chattyer.nlp.wit.client.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

import chattyer.nlp.wit.models.ListResponse;

public class ListEntitiesResponse extends ListResponse<String> {

    @JsonCreator
    public ListEntitiesResponse(List<String> entities) {
        super(entities);
    }

}
