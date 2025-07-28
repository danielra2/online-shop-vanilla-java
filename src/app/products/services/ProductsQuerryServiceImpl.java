package app.products.services;

import app.products.models.Products;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsQuerryServiceImpl implements ProductsQuerryService {

    private List<Products>productsList;

    public ProductsQuerryServiceImpl(){
        this.productsList=new ArrayList<>();
        load();
    }


    @Override
    public Products getProductByName(String nume) {
        for(int i=0;i<productsList.size();i++){
            if(this.productsList.get(i).getName().equalsIgnoreCase(nume)){
                return this.productsList.get(i);
            }
        }
        return null;
    }

    @Override
    public Products getProductById(int id) {
        for(int i=0;i<productsList.size();i++){
            if(productsList.get(i).getId()==id){
                return productsList.get(i);
            }
        }
        return null;
    }

    @Override
    public int getStockByProductName(String name) {
        for(int i=0;i<productsList.size();i++){
            if(productsList.get(i).getName().equalsIgnoreCase(name)){
                return productsList.get(i).getStock();
            }
        }
        return 0;
    }

    @Override
    public List<Products> allProductsFromOrder(List<Integer> productIds) {
        List<Products>products=new ArrayList<>();
        for(int i=0;i<productsList.size();i++){
            if(productIds.contains(productsList.get(i).getId())){
                products.add(productsList.get(i));
            }
        }
        return products;
    }

    @Override
    public void afisareProduse() {
        for(int i=0;i<productsList.size();i++){
            System.out.println(productsList.get(i).getName());
        }
    }

    @Override
    public List<Products> getAllProduct() {
        return this.productsList;
    }

    @Override
    public void load() {
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
    public Products getProductIdByName(String name) {
        for(int i=0;i<productsList.size();i++){
            if(productsList.get(i).getName().equalsIgnoreCase(name)){
                return productsList.get(i);
            }
        }
        return null;
    }
    }

