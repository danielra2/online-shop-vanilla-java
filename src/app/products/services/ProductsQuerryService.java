package app.products.services;

import app.products.models.Products;

import java.util.List;

public interface ProductsQuerryService {
    public Products getProductByName(String nume);
    public Products getProductById(int id);
    public int getStockByProductName(String name);
    public List<Products>allProductsFromOrder(List<Integer>productIds);
    public void afisareProduse();
    List<Products>getAllProduct();
    public void load();
    public Products getProductIdByName(String name);
}
