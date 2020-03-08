package chattyer.nlp.wit.client.entities;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import chattyer.nlp.wit.client.ResponseMapper;
import okhttp3.Response;

public class ListEntitiesResponseMapper implements ResponseMapper<ListEntitiesResponse> {

    private ObjectMapper objectMapper;

    public ListEntitiesResponseMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ListEntitiesResponse map(Response response) throws IOException {
        List<String> entities = objectMapper.readValue(response.body()
                                                               .string(),
                                                       new TypeReference<List<String>>() {
                                                       });
        return new ListEntitiesResponse(entities);
    }

}
