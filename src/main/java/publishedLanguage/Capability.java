package publishedLanguage;


import java.io.Serializable;

public record Capability(String name, String type) implements Serializable {

    public static Capability skill(String name) {
        return new Capability(name, "SKILL");
    }

    public static Capability permission(String name) {
        return new Capability(name, "PERMISSION");
    }

    public static Capability asset(String asset) {
        return new Capability(asset, "ASSET");
    }

    public static Capability vehicle(String name) {
        return new Capability(name, "VEHICLE");
    }

}