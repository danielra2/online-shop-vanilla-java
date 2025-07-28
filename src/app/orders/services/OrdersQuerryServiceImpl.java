package app.orders.services;

import app.orders.models.Orders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrdersQuerryServiceImpl implements OrdersQuerryService{
    List<Orders> orders;

    public OrdersQuerryServiceImpl(){
        this.orders=new ArrayList<>();
    }

    @Override
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

    @Override
    public List<Orders> ordersByCustomerId(int id) {
        List<Orders> ordersList = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCustomerId() == id) {
                ordersList.add(orders.get(i));
            }
        }
        return ordersList;
    }

    @Override
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

    @Override
    public List<Orders> getAllOrdersByIds(List<Integer> orderDetailsList) {
        List<Orders>ordersList=new ArrayList<>();
        for(int i=0;i<orders.size();i++){
            if(orderDetailsList.contains(orders.get(i).getId())){
                ordersList.add(orders.get(i));

            }


        }
        return ordersList;
    }
}

