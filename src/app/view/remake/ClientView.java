package app.view.remake;

import app.orders.models.Orders;
import app.users.services.UsersService;
import app.users.services.UsersCommandServiceSingleton;

import java.util.List;

public class ClientView extends View {

    public ClientView() {

    }
    private UsersService getUsersService() {
       return null;
    }

    @Override
    public void afiseazaMeniu() {
        System.out.println("====== MENIU CLIENT ======");
        System.out.println("1->Vizualizare Produse");
        System.out.println("2->Show orders by cusotomer id");
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
//    public void showOrdersByCustomerId() {
//        int idCustomer = user.getId();
//        List<Orders> ordersList = ordersService.ordersByCustomerId(idCustomer);
//        if (ordersList.isEmpty()) {
//            System.out.println("Nu exista comenzi");
//        } else {
//            for (int i = 0; i < ordersList.size(); i++) {
//                System.out.println(ordersList.get(i).getId());
//            }
//        }
//    }
}