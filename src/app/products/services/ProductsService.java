package app.products.services;

import app.products.models.Products;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsService {
    private List<Products>productsList;

    public ProductsService(){
        productsList=new ArrayList<>();
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

}
