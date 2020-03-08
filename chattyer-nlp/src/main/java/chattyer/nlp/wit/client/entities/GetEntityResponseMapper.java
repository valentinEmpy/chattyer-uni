package chattyer.nlp.wit.client.entities;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import chattyer.nlp.wit.client.ResponseMapper;
import okhttp3.Response;

public class GetEntityResponseMapper implements ResponseMapper<GetEntityResponse> {

    private ObjectMapper objectMapper;

    public GetEntityResponseMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public GetEntityResponse map(Response response) throws IOException {
        return objectMapper.readValue(response.body()
                                              .string(),
                                      GetEntityResponse.class);
    }

}
