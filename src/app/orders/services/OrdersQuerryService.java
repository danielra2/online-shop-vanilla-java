package app.orders.services;

import app.orders.models.Orders;

import java.util.List;

public interface OrdersQuerryService {
    public void load();
    public List<Orders> ordersByCustomerId(int id);
    public int getNextOrderId();
    public List<Orders>getAllOrdersByIds(List<Integer>orderDetailsList);
}
