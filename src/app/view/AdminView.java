package app.view;

import app.orderDetails.services.OrderDetailsCommandService;
import app.orderDetails.services.OrderDetailsCommandServiceSingleton;
import app.orderDetails.services.OrderDetailsQuerryService;
import app.orderDetails.services.OrderDetailsQuerryServiceSingleton;
import app.orders.services.OrdersCommandService;
import app.orders.services.OrdersCommandServiceSingleton;
import app.orders.services.OrdersQuerryService;
import app.orders.services.OrdersQuerryServiceSingleton;
import app.products.services.ProductsCommandService;
import app.products.services.ProductsCommandServiceSingleton;
import app.products.services.ProductsQuerryService;
import app.products.services.ProductsQuerryServiceSingleton;
import app.users.services.UsersCommandService;
import app.users.services.UsersCommandServiceSingleton;
import app.users.services.UsersQuerryService;
import app.users.services.UsersQuerryServiceSingleton;

import java.util.Scanner;

public class AdminView implements View{

    private Scanner scanner;

    private UsersQuerryService usersQuerryService;
    private UsersCommandService usersCommandService;

    private ProductsQuerryService productsQuerryService;
    private ProductsCommandService productsCommandService;

    private OrdersQuerryService ordersQuerryService;
    private OrdersCommandService ordersCommandService;

    private OrderDetailsQuerryService orderDetailsQuerryService;
    private OrderDetailsCommandService orderDetailsCommandService;

    public AdminView(){
        this.scanner=new Scanner(System.in);

        this.usersCommandService= UsersCommandServiceSingleton.getInstance();
        this.usersQuerryService= UsersQuerryServiceSingleton.getInstance();

        this.ordersQuerryService= OrdersQuerryServiceSingleton.getInstance();
        this.ordersCommandService= OrdersCommandServiceSingleton.getInstance();

        this.productsQuerryService= ProductsQuerryServiceSingleton.getInstance();
        this.productsCommandService= ProductsCommandServiceSingleton.getInstance();

        this.orderDetailsQuerryService= OrderDetailsQuerryServiceSingleton.getInstance();
        this.orderDetailsCommandService= OrderDetailsCommandServiceSingleton.getInstance();

        play();


    }

    public void menu(){
        System.out.println("-----ADMIN VIEW-----");
    }






    @Override
    public void play() {
        this.menu();

    }
}
