package chattyer.nlp.wit.models;

import java.util.List;

public abstract class ListResponse<T> {

    private List<T> entities;

    public ListResponse(List<T> entities) {
        this.entities = entities;
    }

    public List<T> getEntities() {
        return entities;
    }

}
