package app.users.models;

import app.roles.Roles;

import java.util.Arrays;
import java.util.List;

public class Admin extends User {

    private String lastLogin;


    public Admin(int id, String email, String password, String fullName, String role, String lastLogin) {
        super(id, email, password, fullName, Arrays.asList(Roles.ADMIN));
        this.lastLogin = lastLogin;

    }

    public Admin(String text) {
        super(text, Arrays.asList(Roles.ADMIN));
        String[] prop = text.split(",");
        this.lastLogin = prop[5];
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String descriere() {
            String text = "";
            text = getId() + " " + getEmail() + " " + getPassword() + " " + getFullName() + " " + getLastLogin();
            return text;
        }
    }

