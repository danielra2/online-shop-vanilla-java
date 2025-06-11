package app.users.models;

import app.roles.Roles;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String email;
    private String password;
    private String fullName;
    private List<Roles> roles;

    public User(int id, String email, String password, String fullName,List<Roles>roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.roles=roles;
    }
    public User(String text,List<Roles>roles){
        this.roles=new ArrayList<>();
        String[]prop=text.split(",");
        this.id=Integer.parseInt(prop[1]);
        this.email=prop[2];
        this.password=prop[3];
        this.fullName=prop[4];
    }
    public String descriere(){
        return id+","+email+","+password+","+fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Roles> getRoles() {
        return roles;
    }
    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
