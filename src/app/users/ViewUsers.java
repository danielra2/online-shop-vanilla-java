package app.users;

import app.users.models.Admin;
import app.users.models.Client;
import app.users.models.User;
import app.users.models.UserTypes;
import app.users.services.UsersCommandService;
import app.users.services.UsersCommandServiceSingleton;
import app.users.services.UsersQuerryService;
import app.users.services.UsersQuerryServiceSingleton;

import java.util.List;
import java.util.Scanner;

public class ViewUsers {
    private Scanner scanner;
    private UsersQuerryService usersQuerryService;
    private UsersCommandService usersCommandService;

    public ViewUsers(){
        scanner=new Scanner(System.in);
        this.usersCommandService= UsersCommandServiceSingleton.getInstance();
        this.usersQuerryService= UsersQuerryServiceSingleton.getInstance();
        run();
    }

    public void meniu(){
        System.out.println("1->Afiseaza toti userii");
        System.out.println("2->Adauga user");
        System.out.println("3->Gaseste user");
    }
    public void run(){
        boolean merge=true;
        while(merge){
            this.meniu();
            int alegere= Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:
                    afisare();
                break;
                case 2:
                    add();
                    break;
                case 3:
                    viewGetUserByNameAndPassword();
                    break;


            }
        }
    }
    public void afisare(){
        List<User>userList=this.usersQuerryService.getAllUser();
        for(int i=0;i<userList.size();i++){
            System.out.println(userList.get(i).descriere());
        }
    }

    public void add(){

        System.out.println("Introduceti datele de forma:\nCLIENT,1,john.doe@gmail.com,parola,John Doe,0774098218,true sau \nADMIN,3,marian.ionescu@outlook.com,parola,Marian Ionescu,17-07-2024");

        String text=scanner.nextLine();

        UserTypes types= UserTypes.valueOf(text.split(",")[0].toUpperCase());

        if (types.equals(UserTypes.ADMIN)) {
            Admin admin=new Admin(text);
            this.usersCommandService.addUser(admin);
            if(admin!=null){
                System.out.println("User adaugat cu succes");
            }
            else{
                System.out.println("Eroare");
            }
        } else {
            Client client=new Client(text);
            this.usersCommandService.addUser(client);
            if(client!=null){
                System.out.println("Client adaugat cu succes");
            }
            else{
                System.out.println("Eroare");
            }
        }
    }

    public void viewGetUserByNameAndPassword(){
        System.out.println("Introduceti numele");
        String nume=scanner.nextLine();
        System.out.println("Introduceti parola");
        String password=scanner.nextLine();

       User user= usersQuerryService.findUserByNameAndPassword(nume,password);
       if(user!=null){
           System.out.println("User gasit cu succes");
           System.out.println("Detalii:"+user.descriere());
       }
       else{
           System.out.println("Userul nu a fost gasit");
       }

    }





}
