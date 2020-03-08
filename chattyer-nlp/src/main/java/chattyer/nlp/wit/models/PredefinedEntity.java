package chattyer.nlp.wit.models;

public enum PredefinedEntity implements Entity {

    INTENT("intent"), LOCATION("wit$location");

    private String witName;

    PredefinedEntity(String witName) {
        this.witName = witName;
    }

    @Override
    public String getName() {
        return witName;
    }

}
