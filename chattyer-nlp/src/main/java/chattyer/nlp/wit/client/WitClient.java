package chattyer.nlp.wit.client;

import chattyer.nlp.wit.client.apps.ApplicationsOperator;
import chattyer.nlp.wit.client.entities.EntitiesOperator;
import chattyer.nlp.wit.analyses.AnalysesOperator;
import chattyer.nlp.wit.client.entities.EntityValueExpressionsOperator;
import chattyer.nlp.wit.client.entities.EntityValuesOperator;
import chattyer.nlp.wit.client.samples.SamplesOperator;

public interface WitClient {

    AnalysesOperator analyses();

    ApplicationsOperator applications();

    EntitiesOperator entities();

    EntityValuesOperator entityValues();

    EntityValueExpressionsOperator entityValueExpressions();

    SamplesOperator samples();

}
