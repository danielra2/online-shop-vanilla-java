package app.users.services;

import app.users.models.Users;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersService {
    private List<Users> usersList;

    public UsersService(){
        usersList=new ArrayList<>();
        load();
    }
    public void load(){
        File file=new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\users\\data\\users.txt");
        try{
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                this.usersList.add(new Users(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String toSave(){
        String text="";
        for(int i=0;i<usersList.size()-1;i++){
            text+=this.usersList.get(i).proprietati()+"\n";
        }
        text+=this.usersList.get(usersList.size()-1).proprietati();
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
    public void add(Users user){
        this.usersList.add(user);
    }
}
