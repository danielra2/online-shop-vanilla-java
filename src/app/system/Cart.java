package app.system;

import app.products.models.Products;
import app.products.services.ProductsService;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems;
    private ProductsService productsService;

    public Cart(){
        cartItems=new ArrayList<>();
        productsService=new ProductsService();
    }

    //todo:

    //add item
    public List<CartItem>addItem(Products products ,int quantity){
        CartItem cartItem =getCartItemByName(products.getName());
        if(cartItem!=null){
            cartItem.setQuantity(cartItem.getQuantity()+quantity);
        }else{
            CartItem cartItemNew = new CartItem(products,quantity);
            this.cartItems.add(cartItemNew);

        }
        return cartItems;
    }

    //erase item
    public boolean eraseItem(String productName){
        CartItem cartItem=getCartItemByName(productName);
        if(cartItem!=null&&cartItems.contains(cartItem)){
            cartItems.remove(cartItem);
            return true;
        }
        else{
            return false;
        }
    }

    //show  items
    public void showItems(){
        if(cartItems.isEmpty()){
            System.out.println("Cart item is empty");
        }
        for(int i=0;i<cartItems.size();i++){
            System.out.println(cartItems.get(i).describe());
        }

    }

    //todo:getCartItemByName
    public CartItem getCartItemByName(String name){
        for(int i=0;i<cartItems.size();i++){
            if(cartItems.get(i).getProduct().getName().equalsIgnoreCase(name)){
                return cartItems.get(i);
            }
        }
        return null;
    }
    public boolean addMoreItems(Products products,int quantity){
        CartItem cartItem=getCartItemByName(products.getName());
        if(cartItems.contains(cartItem)){
            int newQuantity=cartItem.getQuantity()+quantity;
            cartItem.setQuantity(newQuantity);
            return true;
        }
       else if(!cartItems.contains(cartItem)){
           return false;
        }
       return true;
    }
    public boolean eraseSomeItems(Products products,int quantity){
        CartItem cartItem=getCartItemByName(products.getName());
        if(cartItems.contains(cartItem)){
            int newQuantity=cartItem.getQuantity()-quantity;
            if(newQuantity>0){
                cartItem.setQuantity(newQuantity);
                return true;
            }
            else if(!cartItems.contains(cartItem)){
                return false;
            }
            return true;

        }

        else{
            return false;
        }
    }
    public int cartTotalPrice(){
        int price=0;
        for(int i=0;i<cartItems.size();i++){
            price+=cartItems.get(i).getProduct().getPrice();
        }
        return price;
    }




}
