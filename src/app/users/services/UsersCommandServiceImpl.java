package app.users.services;

import app.users.models.User;
import app.users.models.UserTypes;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersCommandServiceImpl implements UsersCommandService {
    List<User> userList;
    public UsersCommandServiceImpl(){
        this.userList=new ArrayList<>();
        load();
    }
    public void load() {
        File file = new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\users\\data\\users.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[]parti=line.split(",");
                UserTypes tip=UserTypes.valueOf(parti[0]);
                User user=User.fabricaUser(tip,line);
                if(user!=null){
                    this.userList.add(user);
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
    public User getUserByNameAndPassword(String name,String password){
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getFullName().equalsIgnoreCase(name)&&userList.get(i).getPassword().equalsIgnoreCase(password)){
                return userList.get(i);
            }
        }
        return null;
    }


    @Override
    public void addUser(User user) {
        this.userList.add(user);
    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }
}
