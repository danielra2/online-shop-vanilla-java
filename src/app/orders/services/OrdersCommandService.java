package app.orders.services;

import app.orders.models.Orders;

public interface OrdersCommandService {
    public void add(Orders orders);
    public boolean cancelOrder(int id);
    public String toSave();
    public void save();
    public Orders placeOrder(int id, int customerId, int ammount, String shippingAddress, String orderedDate);
}
