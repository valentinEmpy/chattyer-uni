package chattyer.nlp.wit.client.entities;

public interface EntitiesOperator {

    ListEntitiesResponse list(ListEntitiesRequest request);

    PostEntityResponse post(PostEntityRequest request);

    GetEntityResponse get(GetEntityRequest request);

    void update(UpdateEntityRequest request);

    void delete(DeleteEntityRequest request);

}
