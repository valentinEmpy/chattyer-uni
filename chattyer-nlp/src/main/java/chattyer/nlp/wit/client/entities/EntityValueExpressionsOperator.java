package chattyer.nlp.wit.client.entities;

public interface EntityValueExpressionsOperator {

    void post(PostEntityValueExpressionRequest request);

    void delete(DeleteEntityValueExpressionRequest request);

}
