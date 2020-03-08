package chattyer.nlp.wit.client.samples;

import java.util.ArrayList;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractOperator;
import chattyer.nlp.wit.client.PaginatedWitRequest;
import chattyer.nlp.wit.client.WitRequest;
import okhttp3.Request;

public class SamplesOperatorImpl extends AbstractOperator implements SamplesOperator {

    public SamplesOperatorImpl(WitContext witContext) {
        super(witContext);
    }

    @Override
    public ListSamplesResponse list(ListSamplesRequest request) {
        PaginatedWitRequest paginatedWitRequest = request;
        ListSamplesResponseMapper responseMapper = new ListSamplesResponseMapper(getWitContext().getObjectMapper());
        ListSamplesResponse fullResponse = new ListSamplesResponse(new ArrayList<>());
        while (true) {
            ListSamplesResponse currentResponse = executeAndMapResponse(toHttpRequest(paginatedWitRequest), responseMapper);
            fullResponse.getEntities()
                        .addAll(currentResponse.getEntities());
            if (currentResponse.getEntities()
                               .isEmpty()) {
                return fullResponse;
            }
            paginatedWitRequest = paginatedWitRequest.getForNextPage(getWitContext());
        }
    }

    private Request toHttpRequest(WitRequest witRequest) {
        return witRequest.get(getWitContext());
    }

    @Override
    public void post(PostSampleRequest request) {
        execute(toHttpRequest(request));
    }

    @Override
    public void delete(DeleteSampleRequest request) {
        execute(toHttpRequest(request));
    }

}
