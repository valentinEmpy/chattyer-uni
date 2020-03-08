package chattyer.nlp.wit.client;

import chattyer.nlp.wit.client.apps.ApplicationsOperatorImpl;
import chattyer.nlp.wit.client.entities.EntitiesOperator;
import chattyer.nlp.wit.client.entities.EntitiesOperatorImpl;
import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.analyses.AnalysesOperator;
import chattyer.nlp.wit.analyses.AnalysesOperatorImpl;
import chattyer.nlp.wit.client.apps.ApplicationsOperator;
import chattyer.nlp.wit.client.entities.EntityValueExpressionsOperator;
import chattyer.nlp.wit.client.entities.EntityValueExpressionsOperatorImpl;
import chattyer.nlp.wit.client.entities.EntityValuesOperator;
import chattyer.nlp.wit.client.entities.EntityValuesOperatorImpl;
import chattyer.nlp.wit.client.samples.SamplesOperator;
import chattyer.nlp.wit.client.samples.SamplesOperatorImpl;

public class DefaultWitClient implements WitClient {

    private WitContext witContext;

    public DefaultWitClient(WitContext witContext) {
        this.witContext = witContext;
    }

    @Override
    public AnalysesOperator analyses() {
        return new AnalysesOperatorImpl(witContext);
    }

    @Override
    public ApplicationsOperator applications() {
        return new ApplicationsOperatorImpl(witContext);
    }

    @Override
    public EntitiesOperator entities() {
        return new EntitiesOperatorImpl(witContext);
    }

    @Override
    public EntityValuesOperator entityValues() {
        return new EntityValuesOperatorImpl(witContext);
    }

    @Override
    public EntityValueExpressionsOperator entityValueExpressions() {
        return new EntityValueExpressionsOperatorImpl(witContext);
    }

    @Override
    public SamplesOperator samples() {
        return new SamplesOperatorImpl(witContext);
    }

}
