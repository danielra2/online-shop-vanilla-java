package app.view.remake;

public class ClientView extends View {

    public ClientView() {

    }

    @Override
    public void afiseazaMeniu() {
        System.out.println("====== MENIU CLIENT ======");
        System.out.println("1->Vizualizare Produse");
    }

    @Override
    public void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Vizualizare Produse...");
                System.out.println("Test");
                break;
        }
    }
}