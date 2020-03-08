package chattyer.nlp.wit.analyses;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractOperator;

public class AnalysesOperatorImpl extends AbstractOperator implements AnalysesOperator {

    public AnalysesOperatorImpl(WitContext witContext) {
        super(witContext);
    }

    @Override
    public AnalyseMessageResponse analyse(AnalyseMessageRequest request) {
        AnalyseMessageResponseMapper responseMapper = new AnalyseMessageResponseMapper(getWitContext().getObjectMapper());
        return executeAndMapResponse(request.get(getWitContext()), responseMapper);
    }

}
