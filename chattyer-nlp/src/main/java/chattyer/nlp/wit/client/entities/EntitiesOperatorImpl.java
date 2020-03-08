package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractOperator;
import chattyer.nlp.wit.client.WitRequest;
import okhttp3.Request;

public class EntitiesOperatorImpl extends AbstractOperator implements EntitiesOperator {

    public EntitiesOperatorImpl(WitContext witContext) {
        super(witContext);
    }

    @Override
    public ListEntitiesResponse list(ListEntitiesRequest request) {
        ListEntitiesResponseMapper responseMapper = new ListEntitiesResponseMapper(getWitContext().getObjectMapper());
        return executeAndMapResponse(toHttpRequest(request), responseMapper);
    }

    private Request toHttpRequest(WitRequest witRequest) {
        return witRequest.get(getWitContext());
    }

    @Override
    public PostEntityResponse post(PostEntityRequest request) {
        PostEntityResponseMapper responseMapper = new PostEntityResponseMapper(getWitContext().getObjectMapper());
        return executeAndMapResponse(toHttpRequest(request), responseMapper);
    }

    @Override
    public GetEntityResponse get(GetEntityRequest request) {
        GetEntityResponseMapper responseMapper = new GetEntityResponseMapper(getWitContext().getObjectMapper());
        return executeAndMapResponse(toHttpRequest(request), responseMapper);
    }

    @Override
    public void update(UpdateEntityRequest request) {
        execute(toHttpRequest(request));
    }

    @Override
    public void delete(DeleteEntityRequest request) {
        execute(toHttpRequest(request));
    }

}
