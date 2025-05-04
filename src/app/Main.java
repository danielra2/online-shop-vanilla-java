package app;

import app.orderDetails.models.OrderDetails;
import app.orderDetails.services.OrderDetailsService;
import app.orders.models.Orders;
import app.orders.services.OrdersService;
import app.products.models.Products;
import app.products.services.ProductsService;
import app.users.models.Users;
import app.users.services.UsersService;

public class Main {
    public static void main(String[] args) {
        ProductsService productsService=new ProductsService();
        Products products=new Products("1,Laptop Lenovo,3200,Ultrabook 15 inch,2024-11-15,25");
        productsService.add(products);
        productsService.save();

        OrdersService ordersService=new OrdersService();
        Orders orders=new Orders("1,101,3200,Bulevardul Unirii 45, Bucuresti");
        ordersService.add(orders);
        ordersService.save();

        OrderDetailsService orderDetailsService=new OrderDetailsService();
        OrderDetails orderDetails=new OrderDetails("1,1,1,3200,1");
        orderDetailsService.add(orderDetails);
        orderDetailsService.Save();

        UsersService usersService=new UsersService();
        Users user=new Users("1,john.doe@gmail.com,parola,John Doe");
        usersService.add(user);
        usersService.save();

    }
}