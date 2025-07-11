package app.view.remake;

import app.users.models.User;
import app.users.models.UserTypes;
import app.users.services.UsersService;

import java.util.Scanner;

public class ViewService {
    private UsersService usersService;
    private Scanner scanner;
    private User user;

    public ViewService(){
        usersService = new UsersService();
        scanner = new Scanner(System.in);
        user = null;
        play();
    }

    public User login(){
        System.out.println("Enter the name ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter the password");
        String password = scanner.nextLine();
        User user = usersService.getUserByNameAndPassword(name, password);

        if(user != null){
            System.out.println("Welcome " + name);
            return user;
        }
        else{
            System.out.println("Login failed");
        }
        return null;
    }

    public void loginMenu(){
        System.out.println("1->Login");
        System.out.println("0->Exit");
    }

    public void play(){
        boolean isRunning = true;
        while(isRunning){
            if(user == null){
                this.loginMenu();
                int choice = scanner.nextInt();
                if(choice == 0) {
                    isRunning = false;
                }
                user = login();
            }
            else{
                UserTypes types = user.getUserType();
                View view = View.fabricaView(types);
                int menuChoice = scanner.nextInt();
                view.handleMenuChoice(menuChoice);
            }
        }
    }
}