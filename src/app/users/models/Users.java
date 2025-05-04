package app.users.models;

public class Users {
    private int id;
    private String email;
    private String password;
    private String fullName;

    public Users(int id, String email, String password, String fullName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }
    public Users(String text){
        String[]prop=text.split(",");
        this.id=Integer.parseInt(prop[0]);
        this.email=prop[1];
        this.password=prop[2];
        this.fullName=prop[3];
    }
    public String proprietati(){
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
}
