package chattyer.persistence.models;

public enum RoleType {
    AUDITOR(1), DEVELOPER(2), MANAGER(3), ADMIN(4), GLOBAL_ADMIN(5);

    private int strength;

    RoleType(int strength) {
        this.strength = strength;
    }

    public boolean covers(RoleType other) {
        return this.strength >= other.strength;
    }
}
