package chattyer.nlp.wit.client.apps;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import chattyer.nlp.wit.client.ResponseMapper;
import okhttp3.Response;

public class PostApplicationResponseMapper implements ResponseMapper<PostApplicationResponse> {

    private ObjectMapper objectMapper;

    public PostApplicationResponseMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public PostApplicationResponse map(Response response) throws IOException {
        return objectMapper.readValue(response.body()
                                              .string(),
                                      PostApplicationResponse.class);
    }
}
