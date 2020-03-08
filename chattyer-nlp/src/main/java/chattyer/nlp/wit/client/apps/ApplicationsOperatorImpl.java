package chattyer.nlp.wit.client.apps;

import java.util.ArrayList;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractOperator;
import chattyer.nlp.wit.client.PaginatedWitRequest;
import chattyer.nlp.wit.client.WitRequest;
import okhttp3.Request;

public class ApplicationsOperatorImpl extends AbstractOperator implements ApplicationsOperator {

    public ApplicationsOperatorImpl(WitContext witContext) {
        super(witContext);
    }

    @Override
    public ListApplicationsResponse list() {
        PaginatedWitRequest paginatedWitRequest = ImmutableListApplicationsWitRequest.builder()
                                                                                     .build();
        ListApplicationsResponseMapper responseMapper = new ListApplicationsResponseMapper(getWitContext().getObjectMapper());
        ListApplicationsResponse fullResponse = new ListApplicationsResponse(new ArrayList<>());
        while (true) {
            ListApplicationsResponse currentResponse = executeAndMapResponse(toHttpRequest(paginatedWitRequest), responseMapper);
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
    public GetApplicationResponse get(GetApplicationRequest request) {
        GetApplicationResponseMapper responseMapper = new GetApplicationResponseMapper(getWitContext().getObjectMapper());
        return executeAndMapResponse(toHttpRequest(request), responseMapper);
    }

    @Override
    public PostApplicationResponse post(PostApplicationRequest request) {
        PostApplicationResponseMapper responseMapper = new PostApplicationResponseMapper(getWitContext().getObjectMapper());
        return executeAndMapResponse(toHttpRequest(request), responseMapper);
    }

    @Override
    public void delete(DeleteApplicationRequest request) {
        execute(toHttpRequest(request));
    }

}
