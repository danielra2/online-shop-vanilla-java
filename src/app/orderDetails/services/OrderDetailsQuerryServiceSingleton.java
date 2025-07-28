package app.orderDetails.services;

public class OrderDetailsQuerryServiceSingleton {
    public static class LazyHolder{
        private static final OrderDetailsQuerryService ORDER_DETAILS_QUERRY_SERVICE=new OrderDetailsQuerryServiceImpl();
    }
    public static OrderDetailsQuerryService getInstance(){
        return LazyHolder.ORDER_DETAILS_QUERRY_SERVICE;

    }
}
