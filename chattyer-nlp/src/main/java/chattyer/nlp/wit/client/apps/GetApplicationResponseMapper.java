package chattyer.nlp.wit.client.apps;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import chattyer.nlp.wit.client.ResponseMapper;
import okhttp3.Response;

public class GetApplicationResponseMapper implements ResponseMapper<GetApplicationResponse> {

    private ObjectMapper objectMapper;

    public GetApplicationResponseMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public GetApplicationResponse map(Response response) throws IOException {
        return objectMapper.readValue(response.body()
                                              .string(),
                                      GetApplicationResponse.class);
    }

}
