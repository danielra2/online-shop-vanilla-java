package app.products.services;

public class ProductsCommandServiceSingleton {
    private static class LazyHolder{
        private static final ProductsCommandService PRODUCTS_COMMAND_SERVICE=new ProductsCommandServiceImpl();
    }
    public static ProductsCommandService getInstance(){

        return LazyHolder.PRODUCTS_COMMAND_SERVICE;
    }
}
