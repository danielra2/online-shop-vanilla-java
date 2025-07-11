package app.view.remake;

public class AdminView extends View {

    public AdminView() {

    }

    @Override
    public void afiseazaMeniu() {
        System.out.println("====== MENIU ADMIN ======");
    }

    @Override
    public void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("ADMIN");
                break;
        }
    }
}