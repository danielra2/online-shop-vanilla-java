package app.roles;

public enum Roles {
    CLIENT(
            Permission.READ_PRODUCTS
    ),
    ADMIN(
            Permission.READ_PRODUCTS,
            Permission.WRITE_PRODUCTS,
            Permission.DELETE_PRODUCTS
    );
    private final Permission[]permissions;

    Roles(Permission...permissions){
        this.permissions=permissions;
    }
    public Permission[]getPermissions(){
        return permissions;
    }

}
