package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractOperator;
import chattyer.nlp.wit.client.WitRequest;
import okhttp3.Request;

public class EntityValueExpressionsOperatorImpl extends AbstractOperator implements EntityValueExpressionsOperator {

    public EntityValueExpressionsOperatorImpl(WitContext witContext) {
        super(witContext);
    }

    @Override
    public void post(PostEntityValueExpressionRequest request) {
        execute(toHttpRequest(request));
    }

    private Request toHttpRequest(WitRequest witRequest) {
        return witRequest.get(getWitContext());
    }

    @Override
    public void delete(DeleteEntityValueExpressionRequest request) {
        execute(toHttpRequest(request));
    }
}
