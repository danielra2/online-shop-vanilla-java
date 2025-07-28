package app.products.services;

import app.products.models.Products;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsCommandServiceImpl implements ProductsCommandService{

    List<Products>productsList;
    public ProductsCommandServiceImpl(){
        this.productsList=new ArrayList<>();

    }
    @Override
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
    @Override
    public void addProduct() {

    }

    @Override
    public void removeProductByName(String name) {

    }

    @Override
    public void editProduct(Products product) {

    }
}
