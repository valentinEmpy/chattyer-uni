package chattyer.nlp.wit.analyses;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import chattyer.nlp.wit.client.ResponseMapper;
import okhttp3.Response;

public class AnalyseMessageResponseMapper implements ResponseMapper<AnalyseMessageResponse> {

    private ObjectMapper objectMapper;

    public AnalyseMessageResponseMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public AnalyseMessageResponse map(Response response) throws IOException {
        return objectMapper.readValue(response.body()
                                              .string(),
                                      AnalyseMessageResponse.class);
    }
}
