package chattyer.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;

enum SchemaVersion {
    @JsonProperty("1.0")
    ONE(1);

    private int major;
    private int minor;

    SchemaVersion(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }

    SchemaVersion(int major) {
        this.major = major;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

}
