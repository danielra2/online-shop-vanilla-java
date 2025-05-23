package app.orders.services;

import app.orderDetails.models.OrderDetails;
import app.orders.models.Orders;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrdersService {
    private List<Orders> orders;

    public OrdersService() {
        orders = new ArrayList<>();
        load();
    }

    public void load() {
        File file = new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\orders\\data\\orders.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.orders.add(new Orders(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String toSave() {
        String text = "";
        for (int i = 0; i < orders.size() - 1; i++) {
            text += this.orders.get(i).proprietati() + "\n";
        }
        text += this.orders.get(orders.size() - 1).proprietati();
        return text.trim();
    }

    public void save() {
        File file = new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\orders\\data\\orders.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this.toSave());
            printWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void add(Orders orders) {
        this.orders.add(orders);
    }


    //todo: afisez toate comenzile care au un anumit customerId
    public List<Orders> ordersByCustomerId(int id) {
        List<Orders> ordersList = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCustomerId() == id) {
                ordersList.add(orders.get(i));
            }
        }
        return ordersList;
    }

    public Orders placeOrder(int id, int customerId, int ammount, String shippingAddress, String orderedDate) {
        Orders order = new Orders(id, customerId, ammount, shippingAddress, orderedDate);
        if (order != null) {
            this.save();
            return order;

        }
        return null;
    }

    public int getNextOrderId() {
        if (orders.isEmpty()) {
            return 1;
        }
        int maxId = 0;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() > maxId) {
                maxId = orders.get(i).getId();
            }
        }
        return maxId + 1;
    }

    public boolean cancelOrder(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.remove(orders.get(i));
                return true;
            }
        }
        return false;
    }
    public List<Orders>getAllOrdersByIds(List<Integer>orderDetailsList){
        List<Orders>ordersList=new ArrayList<>();
        for(int i=0;i<orders.size();i++){
            if(orderDetailsList.contains(orders.get(i).getId())){
                ordersList.add(orders.get(i));

            }


        }
        return ordersList;
    }


}




