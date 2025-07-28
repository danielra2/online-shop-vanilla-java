package app.orderDetails.services;

public class OrderDetailsCommandServiceSingleton {
    public static class LazyHolder{
        private static final OrderDetailsCommandService ORDER_DETAILS_COMMAND_SERVICE=new OrderDetailsCommandServiceImpl();
    }
    public static OrderDetailsCommandService getInstance(){
        return LazyHolder.ORDER_DETAILS_COMMAND_SERVICE;
    }
}
