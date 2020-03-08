package chattyer.nlp.wit.client.samples;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import chattyer.nlp.wit.client.ResponseMapper;
import okhttp3.Response;

public class ListSamplesResponseMapper implements ResponseMapper<ListSamplesResponse> {

    private ObjectMapper objectMapper;

    public ListSamplesResponseMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ListSamplesResponse map(Response response) throws IOException {
        return objectMapper.readValue(response.body()
                                              .string(),
                                      ListSamplesResponse.class);
    }

}
