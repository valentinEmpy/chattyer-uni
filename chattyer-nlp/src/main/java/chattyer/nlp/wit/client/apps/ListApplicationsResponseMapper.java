package chattyer.nlp.wit.client.apps;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import chattyer.nlp.wit.client.ResponseMapper;
import okhttp3.Response;

public class ListApplicationsResponseMapper implements ResponseMapper<ListApplicationsResponse> {

    private ObjectMapper objectMapper;

    public ListApplicationsResponseMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ListApplicationsResponse map(Response response) throws IOException {
        return objectMapper.readValue(response.body()
                                              .string(),
                                      ListApplicationsResponse.class);
    }

}
