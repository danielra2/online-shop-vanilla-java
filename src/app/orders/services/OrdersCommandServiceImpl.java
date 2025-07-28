package app.orders.services;

import app.orders.models.Orders;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrdersCommandServiceImpl implements OrdersCommandService{
    List<Orders> orders;
    public OrdersCommandServiceImpl(){
        this.orders=new ArrayList<>();
    }
    public void load(){
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

    @Override
    public void add(Orders orders) {
        this.orders.add(orders);

    }

    @Override
    public boolean cancelOrder(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.remove(orders.get(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public String toSave() {
        String text = "";
        for (int i = 0; i < orders.size() - 1; i++) {
            text += this.orders.get(i).proprietati() + "\n";
        }
        text += this.orders.get(orders.size() - 1).proprietati();
        return text.trim();
    }

    @Override
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

    @Override
    public Orders placeOrder(int id, int customerId, int ammount, String shippingAddress, String orderedDate) {
        Orders order = new Orders(id, customerId, ammount, shippingAddress, orderedDate);
        if (order != null) {
            this.save();
            return order;

        }
        return null;
    }
}
