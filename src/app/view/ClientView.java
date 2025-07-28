package app.view;

import app.UserSession;
import app.orderDetails.models.OrderDetails;
import app.orderDetails.services.OrderDetailsCommandService;
import app.orderDetails.services.OrderDetailsCommandServiceSingleton;
import app.orderDetails.services.OrderDetailsQuerryService;
import app.orderDetails.services.OrderDetailsQuerryServiceSingleton;
import app.orders.models.Orders;
import app.orders.services.OrdersCommandService;
import app.orders.services.OrdersCommandServiceSingleton;
import app.orders.services.OrdersQuerryService;
import app.orders.services.OrdersQuerryServiceSingleton;
import app.products.models.Products;
import app.products.services.ProductsCommandService;
import app.products.services.ProductsCommandServiceSingleton;
import app.products.services.ProductsQuerryService;
import app.products.services.ProductsQuerryServiceSingleton;
import app.system.Cart;
import app.system.CartItem;
import app.system.PopularProduct;
import app.users.models.User;
import app.users.services.UsersCommandService;
import app.users.services.UsersCommandServiceSingleton;
import app.users.services.UsersQuerryService;
import app.users.services.UsersQuerryServiceSingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientView implements View {

    private Scanner scanner;

    private UsersQuerryService usersQuerryService;
    private UsersCommandService usersCommandService;

    private ProductsQuerryService productsQuerryService;
    private ProductsCommandService productsCommandService;

    private OrdersQuerryService ordersQuerryService;
    private OrdersCommandService ordersCommandService;

    private OrderDetailsQuerryService orderDetailsQuerryService;
    private OrderDetailsCommandService orderDetailsCommandService;

    private Cart cart;


    public ClientView() {
        this.scanner = new Scanner(System.in);

        this.usersCommandService = UsersCommandServiceSingleton.getInstance();
        this.usersQuerryService = UsersQuerryServiceSingleton.getInstance();

        this.ordersQuerryService = OrdersQuerryServiceSingleton.getInstance();
        this.ordersCommandService = OrdersCommandServiceSingleton.getInstance();

        this.productsQuerryService = ProductsQuerryServiceSingleton.getInstance();
        this.productsCommandService = ProductsCommandServiceSingleton.getInstance();

        this.orderDetailsQuerryService = OrderDetailsQuerryServiceSingleton.getInstance();
        this.orderDetailsCommandService = OrderDetailsCommandServiceSingleton.getInstance();
        cart = new Cart();


        play();


    }


    @Override
    public void play() {
        boolean isRunning = true;
        while (isRunning) {
            this.meniu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    afisareProduse();
                    break;
                case 2:
                    showOrdersByCustomerId();
                    break;
                case 3:
                    showAllProductDetailsFromOrder();
                    break;
                case 4:
                    showAddItem();
                    break;
                case 5:
                    viewCart();
                    break;
                case 6:
                    showEraseItem();
                    break;
                case 7:
                    editCart();
                    break;
                case 8:
                    placeOrder();
                    break;
                case 9:
                    viewCancelOrder();
                    break;
                case 10:
                    viewStockByProductName();
                    break;
                case 11:
                    viewMostPopularProduct();
                    break;
                case 12:
                    viewAllOrderedProducts();
                    break;
                case 13:
                    viewAllDates();
                    break;

            }
        }

    }

    public void meniu() {
        System.out.println("-----CLIENT MENU-----");
        System.out.println("1->Show store products");
        System.out.println("2->Show orders by user id");
        System.out.println("3->Show all product details from order");
        System.out.println("4->Add item");
        System.out.println("5->View cart");
        System.out.println("6->Erase item");
        System.out.println("7->Edit cart");
        System.out.println("8->Place order");
        System.out.println("9->Cancel order");
        System.out.println("10->View stock by product name");
        System.out.println("11->View most popular product");
        System.out.println("12->View all ordered products");
        System.out.println("13->View all dates");
    }


    public void afisareProduse() {
        List<Products> produse = productsQuerryService.getAllProduct();
        for (int i = 0; i < produse.size(); i++) {
            System.out.println(produse.get(i).getName());
        }
    }

    public void showOrdersByCustomerId() {
        User user = UserSession.getInstance().getCurrentUser();
        int idCustomer = user.getId();
        List<Orders> ordersList = ordersQuerryService.ordersByCustomerId(idCustomer);
        if (ordersList.isEmpty()) {
            System.out.println("Nu exista comenzi");
        } else {
            for (int i = 0; i < ordersList.size(); i++) {
                System.out.println(ordersList.get(i).getId());
            }
        }
    }

    public void showAllProductDetailsFromOrder() {

        System.out.println("Type the order id");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        List<OrderDetails> orderDetailsList = orderDetailsQuerryService.getAllOrderDetailsByOrderId(orderId);
        if (orderDetailsList.isEmpty()) {
            System.out.println("Nu exista comenzi");
        } else {
            for (int i = 0; i < orderDetailsList.size(); i++) {
                Products products = this.productsQuerryService.getProductById(orderDetailsList.get(i).getProductId());
                System.out.println(products.getName() + " " + products.getDescriptions());

            }
        }

    }

    public void showAddItem() {
        System.out.println("What would you like to buy today?");
        String name = scanner.nextLine();
        System.out.println("How many " + name + "would you like to buy?");
        int quantity = scanner.nextInt();
        Products products = productsQuerryService.getProductByName(name);
        if (products != null && products.getStock() - quantity > 0) {
            System.out.println("You added " + quantity + " " + products.getName() + " in the cart");
            cart.addItem(products, quantity);
        } else if (products != null && products.getStock() - quantity < 0) {
            System.out.println("Indisponible stock");
        } else {
            System.out.println("This product doesn t exist!!!!!!");
        }
    }

    public void viewCart() {
        cart.showItems();
    }

    public void showEraseItem() {
        System.out.println("What product would you like to delete from the cart?");
        String name = scanner.nextLine();
        if (cart.eraseItem(name)) {
            System.out.println("You erased " + name);
        } else {
            System.out.println("You can t delete a product that is not in the cart");
        }
    }

    public void editCart() {
        System.out.println("What item would you like to edit?");
        String itemName = scanner.nextLine();
        Products products = productsQuerryService.getProductByName(itemName);
        if (products == null) {
            System.out.println("This product doesn t exist!");
            return;

        }
        System.out.println("Would you like to add or erase items this type");
        String choice = scanner.nextLine();
        if (choice.equals("+")) {
            System.out.println("How many more items would you like to add to the cart?");
            int quantity = scanner.nextInt();
            if (cart.addMoreItems(products, quantity)) {
                System.out.println("You added " + quantity + " more " + products.getName());
            } else {
                System.out.println("This product doesn t exist in the cart");
            }
        } else if (choice.equals("-")) {
            System.out.println("How many more items would you like to erase to the cart?");
            int quantity = scanner.nextInt();
            if (cart.eraseSomeItems(products, quantity)) {
                System.out.println("You erased " + quantity + " more " + products.getName());
            } else {
                System.out.println("This product doesn t exist in the cart");
            }

        }

    }

    public void placeOrder() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty, add some items in the cart!");
            return;
        }
        System.out.println("Enter the shipping address");
        String address = scanner.nextLine();
        int totalAmount = cart.cartTotalPrice();
        int newOrderId = ordersQuerryService.getNextOrderId();
        String orderedDate = "12.05.2025";
        User user = UserSession.getInstance().getCurrentUser();
        Orders newOrder = new Orders(newOrderId, user.getId(), totalAmount, address, orderedDate);
        ordersCommandService.add(newOrder);

        List<CartItem> cartItems = cart.getItems();
        for (int i = 0; i < cartItems.size(); i++) {
            CartItem item = cartItems.get(i);
            int orderDetailId = orderDetailsQuerryService.getNextOrderDetailId();
            Products product = item.getProduct();
            OrderDetails orderDetail = new OrderDetails(orderDetailId, newOrderId, product.getId(), product.getPrice(), item.getQuantity());
            orderDetailsCommandService.add(orderDetail);
            product.setStock(product.getStock() - item.getQuantity());
        }
        cart.clearCart();
        System.out.println("Order placed successfully!Order ID: " + newOrderId);
        System.out.println("Total amount: " + totalAmount);
    }

    public void viewCancelOrder() {
        System.out.println("Enter the order id you want to cancel");
        int id = scanner.nextInt();
        List<OrderDetails> orderDetails = orderDetailsQuerryService.getAllOrderDetailsByOrderId(id);
        for (int i = 0; i < orderDetails.size(); i++) {
            Products products = productsQuerryService.getProductById(orderDetails.get(i).getProductId());
            int cantitate = orderDetails.get(i).getQuantity();
            products.setStock(products.getStock() + cantitate);
        }
        if (ordersCommandService.cancelOrder(id)) {
            System.out.println("There order with ID " + id + " was cancelled");
        } else {
            System.out.println("Order not found");
        }

    }

    public void viewStockByProductName() {
        System.out.println("For what item would you like to see the stock?");
        String nume = scanner.nextLine();
        int stoc = productsQuerryService.getStockByProductName(nume);
        System.out.println("Stocul este " + stoc);
    }

    public void viewMostPopularProduct() {
        PopularProduct popularProduct = orderDetailsQuerryService.mostPopularProduct();
        if (popularProduct == null) {
            System.out.println("No data");
        } else {
            int id = popularProduct.getPopularProductId();
            Products products = productsQuerryService.getProductById(id);
            System.out.println("The most popular product is: ");
            System.out.println(products.getName());
        }
    }

    public void viewAllOrderedProducts() {
        List<Orders> ordersList = ordersQuerryService.ordersByCustomerId(UserSession.getInstance().getCurrentUser().getId());
        List<Integer> orderIds = new ArrayList<>();
        for (int i = 0; i < ordersList.size(); i++) {
            orderIds.add(ordersList.get(i).getId());
        }
        List<Integer> productsIds = orderDetailsQuerryService.productIds(orderIds);
        List<Products> allOrderedProducts = productsQuerryService.allProductsFromOrder(productsIds);

        System.out.println("Clientul cu id: " + UserSession.getInstance().getCurrentUser().getId() + " a comandat:");
        for (int i = 0; i < allOrderedProducts.size(); i++) {
            System.out.println(allOrderedProducts.get(i).getName());
        }
    }

    //todo:
    public void viewAllDates() {
        System.out.println("For what product would you like to see the order date?");
        String name = scanner.nextLine();
        Products products = productsQuerryService.getProductIdByName(name);
        int id = products.getId();
        List<Integer> orderDetailsList = orderDetailsQuerryService.getOrderIdsFromProductId(id);
        List<Orders> ordersList = ordersQuerryService.getAllOrdersByIds(orderDetailsList);
        System.out.println("The product was ordered at: ");
        for (int i = 0; i < ordersList.size(); i++) {
            System.out.println(ordersList.get(i).getOrderedDate());
        }


    }
}
