package app.orderDetails.services;

import app.orderDetails.models.OrderDetails;

public interface OrderDetailsCommandService {
    public void load();
    public String toSave();
    public void save();
    public void add(OrderDetails orderDetails);

}
