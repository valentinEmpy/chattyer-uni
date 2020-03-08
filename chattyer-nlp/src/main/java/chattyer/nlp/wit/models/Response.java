package chattyer.nlp.wit.models;

public abstract class Response<T> {

    private T entity;

    public Response(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

}
