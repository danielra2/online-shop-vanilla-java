package app.system;

import app.products.models.Products;

public class CartItem {

    private Products product;
    private int quantity;

    public CartItem(Products product,int quantity){
        this.product=product;
        this.quantity=quantity;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String describe(){
        String text="";
        text+=this.product.getName()+" "+this.quantity;
        return text;
    }
}
