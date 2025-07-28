package app.products.services;

import app.products.models.Products;

public interface ProductsCommandService {
    void addProduct();
    void removeProductByName(String name);
    void editProduct(Products product);
    public void load();

}
