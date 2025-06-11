package app.users.services;

import app.users.models.Admin;
import app.users.models.Client;
import app.users.models.User;
import app.users.models.UserTypes;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersService {
    private List<User> userList;

    public UsersService(){
        userList =new ArrayList<>();
        load();
    }
    public void load() {
        File file = new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\users\\data\\users.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                UserTypes types = UserTypes.valueOf(line.split(",")[0]);
                switch (types) {
                    case ADMIN -> this.userList.add(new Admin(line));
                    case CLIENT -> this.userList.add(new Client(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String toSave(){
        String text="";
        for(int i = 0; i< userList.size()-1; i++){
            text+=this.userList.get(i).descriere()+"\n";
        }
        text+=this.userList.get(userList.size()-1).descriere();
        return text.trim();
    }
    public void save(){
        File file=new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\users\\data\\users.txt");
        try{
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(this.toSave());
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void add(User user){
        this.userList.add(user);
    }
    public void afisare(){
        for(int i=0;i<userList.size();i++){
            System.out.println(userList.get(i).descriere());
        }
    }
    public User getUserByNameAndPassword(String name,String password){
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getFullName().equalsIgnoreCase(name)&&userList.get(i).getPassword().equalsIgnoreCase(password)){
                return userList.get(i);
            }
        }
        return null;
    }
}
