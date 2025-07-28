package app;

import app.users.ViewUsers;
import app.users.services.UsersCommandService;
import app.users.services.UsersCommandServiceSingleton;
import app.view.ClientView;
import app.view.LoginView;
import app.view.View;
import app.view.remake.AdminView;
import app.view.remake.ViewService;

public class Main {
    public static void main(String[] args) {


        View view= new LoginView();

    }
}