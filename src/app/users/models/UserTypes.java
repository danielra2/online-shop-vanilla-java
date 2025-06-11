package app.users.models;

public enum UserTypes {
    CLIENT("client"),
    ADMIN("admin");

    private final String type;

    private UserTypes(String type){
        this.type=type;
    }
}
