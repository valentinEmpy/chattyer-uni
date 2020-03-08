package chattyer.nlp.wit.client.entities;

public interface EntityValuesOperator {

    void post(PostEntityValueRequest request);

    void delete(DeleteEntityValueRequest request);

}
