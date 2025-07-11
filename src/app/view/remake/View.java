package app.view.remake;

import app.users.models.User;
import app.users.models.UserTypes;

import java.util.Scanner;

public abstract class View implements ViewPrincipal {
    private Scanner scanner;
    private User currentUser;

    protected View() {
        this.scanner = new Scanner(System.in);
    }

    public abstract void afiseazaMeniu();
    public abstract void handleMenuChoice(int choice);

    public static View fabricaView(UserTypes tip) {
        View view = null;

        switch (tip) {
            case ADMIN -> {
                view= new AdminView();
            }
            case CLIENT -> {
                view= new ClientView();
            }
        }
        if(view!= null){
            view.afiseazaMeniu();
        }
        return view;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}