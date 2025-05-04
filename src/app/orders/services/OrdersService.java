package app.orders.services;

import app.orders.models.Orders;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrdersService {
    private List<Orders>orders;

    public OrdersService(){
        orders=new ArrayList<>();
        load();
    }
    public void load(){
        File file=new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\orders\\data\\orders.txt");
        try{
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                this.orders.add(new Orders(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String toSave(){
        String text="";
        for(int i =0;i<orders.size()-1;i++){
            text+=this.orders.get(i).proprietati()+"\n";
        }
        text+=this.orders.get(orders.size()-1).proprietati();
        return text.trim();
    }
    public void save(){
        File file=new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\orders\\data\\orders.txt");
        try{
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(this.toSave());
            printWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void add(Orders orders){
        this.orders.add(orders);
    }
}
