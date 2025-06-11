package app.users.models;

import app.roles.Roles;

import java.util.Arrays;
import java.util.List;

public class Client extends User{
    private String phoneNumber;
    private boolean isPremiumMember;




    public Client(int id, String email, String password, String fullName, String phoneNumber, boolean isPremiumMember) {
        super(id, email, password, fullName, Arrays.asList(Roles.CLIENT));
        this.phoneNumber=phoneNumber;
        this.isPremiumMember=isPremiumMember;
    }

    public Client(String text) {
        super(text,Arrays.asList(Roles.CLIENT));
        String[]prop=text.split(",");
        this.phoneNumber=prop[5];
        this.isPremiumMember=Boolean.parseBoolean(prop[6]);

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPremiumMember() {
        return isPremiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        isPremiumMember = premiumMember;
    }
    public String descriere(){
       String text="";
       text=getId()+" "+getEmail()+" "+getPassword()+" "+getFullName()+" "+getPhoneNumber()+" "+isPremiumMember;
       return text;
    }
}
