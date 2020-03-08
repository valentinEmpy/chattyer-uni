package chattyer.nlp.wit.client.entities;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import chattyer.nlp.wit.client.ResponseMapper;
import okhttp3.Response;

public class PostEntityResponseMapper implements ResponseMapper<PostEntityResponse> {

    private ObjectMapper objectMapper;

    public PostEntityResponseMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public PostEntityResponse map(Response response) throws IOException {
        return objectMapper.readValue(response.body()
                                              .string(),
                                      PostEntityResponse.class);
    }

}
