package app.view;

import app.UserSession;
import app.roles.Permission;
import app.users.models.Admin;
import app.users.models.Client;
import app.users.models.User;
import app.users.services.UsersCommandService;
import app.users.services.UsersCommandServiceSingleton;
import app.users.services.UsersQuerryService;
import app.users.services.UsersQuerryServiceSingleton;

import java.util.Scanner;

public class LoginView implements View{

    private UsersQuerryService usersQuerryService;
    private UsersCommandService usersCommandService;
    private User user;
    private Scanner scanner;
    private View view;

    public LoginView(){
        this.usersCommandService= UsersCommandServiceSingleton.getInstance();
        this.usersQuerryService= UsersQuerryServiceSingleton.getInstance();
        scanner=new Scanner(System.in);
        play();
    }


    @Override

    public void play() {
        boolean isRunning=true;
        while(isRunning){
            this.meniu();
                int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:
                    login();
                break;
                case 2:
                    isRunning=false;
                    break;

            }
        }

    }

    public User login(){
        System.out.println("Enter the name");
        String name=scanner.nextLine();
        System.out.println("Enter the password");
        String password=scanner.nextLine();
        user=usersQuerryService.findUserByNameAndPassword(name,password);

        if(user!=null){
            System.out.println("Welcome "+user.getFullName());

            UserSession.getInstance().setCurrentUser(user);


            if(user instanceof Client) {
                view= new ClientView();
                view.play();
            }
            else if(user instanceof Admin){
                view =new AdminView();
                view.play();
            }


        }
        else{
            System.out.println("User not found");
        }
        return null;
    }

    public void meniu(){
        System.out.println("1->Login");
        System.out.println("2->Exit");
    }


}
