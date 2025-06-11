package app.view;

import app.roles.Roles;
import app.users.models.User;
import app.users.services.UsersService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViewLogin {
    private UsersService usersService;
    private Scanner scanner;

    public ViewLogin(){
        this.usersService=new UsersService();
        this.scanner=new Scanner(System.in);
    }
    public User login(){
        System.out.println("Enter the name ");
        String name=scanner.nextLine();
        System.out.println("Enter the password");
        String password=scanner.nextLine();
        User user=usersService.getUserByNameAndPassword(name,password);
        List<Roles> rolesList=new ArrayList<>();
        for(int i=0;i<rolesList.size();i++){
            System.out.println(rolesList.get(i).getPermissions());
        }


        if(user!=null){
            System.out.println("Welcome "+name);
            return user;
        }
        else{
            System.out.println("Login failed");
        }
        return null;
    }
}
