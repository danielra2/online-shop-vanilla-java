package app.orders.services;

public class OrdersQuerryServiceSingleton {
    private static class LazyHolder{
        private static final OrdersQuerryService ORDERS_QUERRY_SERVICE=new OrdersQuerryServiceImpl();
    }
    public static OrdersQuerryService getInstance(){
        return LazyHolder.ORDERS_QUERRY_SERVICE;
    }
}
