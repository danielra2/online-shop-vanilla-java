package app.orderDetails.services;

import app.orderDetails.models.OrderDetails;
import app.system.PopularProduct;

import java.util.List;

public interface OrderDetailsQuerryService {
    public void load();
    public int getNextOrderDetailId();
    public PopularProduct getPopularProductId(int id, List<PopularProduct> popularProducts);
    public List<PopularProduct>popularProducts();
    public PopularProduct mostPopularProduct();
    public List<Integer>productIds(List<Integer> orderIds);
    public List<Integer>orderIds(List<Integer>productIds);
    public List<Integer> getOrderIdsFromProductId(int id);
    public List<OrderDetails>getAllOrderDetailsByOrderId(int orderId);

}
