package app.products.services;

import app.orderDetails.models.OrderDetails;
import app.orderDetails.services.OrderDetailsService;
import app.orders.models.Orders;
import app.orders.services.OrdersService;
import app.products.models.Products;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProductsService {
    private List<Products>productsList;
    private OrdersService ordersService;
    private OrderDetailsService orderDetailsService;

    public ProductsService(){
        productsList=new ArrayList<>();
        ordersService=new OrdersService();
        orderDetailsService=new OrderDetailsService();
        load();
    }
    public void load(){
        File file=new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\products\\data\\products.txt");
        try{
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                this.productsList.add(new Products(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void add(Products product){
        this.productsList.add(product);
    }

    public String toSave(){
        String text="";
        for(int i=0;i<productsList.size()-1;i++){
            text+=this.productsList.get(i).proprietati()+"\n";
        }
        text+=this.productsList.get(productsList.size()-1).proprietati();
        return text.trim();
    }

    public void save(){
        File file=new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\products\\data\\products.txt");
        try{
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(this.toSave());
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void afisareProduse(){
        for(int i=0;i<productsList.size();i++){
            System.out.println(productsList.get(i).getName());
        }
    }
    public Products getProductByName(String nume){
        for(int i=0;i<productsList.size();i++){
            if(this.productsList.get(i).getName().equalsIgnoreCase(nume)){
                return this.productsList.get(i);
            }
        }
        return null;
    }
    public int randomId(){
        Random random=new Random();
        int id;
        List<Integer>ids=new ArrayList<>();
        for(int i=0;i<productsList.size();i++){
            ids.add(this.productsList.get(i).getId());

        }
        do{
            id=random.nextInt(1000)+1;

        }while(ids.contains(id));
        return id;
    }
    public String adaugaProdus(int id,String nume,int pret,String description,String createDate,int stock){
        String text=id+","+nume+","+pret+","+description+","+createDate+","+stock;
        return text;
    }


    //todo:get product by id
     public Products getProductById(int id){
        for(int i=0;i<productsList.size();i++){
            if(productsList.get(i).getId()==id){
                return productsList.get(i);
            }
        }
        return null;
     }
     public void updateProducts(Products products){

     }
}
