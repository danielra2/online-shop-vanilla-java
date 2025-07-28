package app.orders.services;

public class OrdersCommandServiceSingleton {
    private static class LazyHolder {
        private static final OrdersCommandService ORDERS_SERVICE = new OrdersCommandServiceImpl();
    }

    public static OrdersCommandService getInstance() {
        return LazyHolder.ORDERS_SERVICE;
    }
}