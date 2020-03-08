package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractOperator;
import chattyer.nlp.wit.client.WitRequest;
import okhttp3.Request;

public class EntityValuesOperatorImpl extends AbstractOperator implements EntityValuesOperator {

    public EntityValuesOperatorImpl(WitContext witContext) {
        super(witContext);
    }

    @Override
    public void post(PostEntityValueRequest request) {
        execute(toHttpRequest(request));
    }

    @Override
    public void delete(DeleteEntityValueRequest request) {
        execute(toHttpRequest(request));
    }

    private Request toHttpRequest(WitRequest witRequest) {
        return witRequest.get(getWitContext());
    }

}
