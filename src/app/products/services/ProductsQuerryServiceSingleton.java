package app.products.services;

public class ProductsQuerryServiceSingleton {
    public static class LazyHolder{
        private static final ProductsQuerryService PRODUCTS_QUERRY_SERVICE=new ProductsQuerryServiceImpl();
    }
    public static ProductsQuerryService getInstance(){
        return LazyHolder.PRODUCTS_QUERRY_SERVICE;
    }

}
