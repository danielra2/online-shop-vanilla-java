package app.orderDetails.services;

import app.orderDetails.models.OrderDetails;
import app.orders.services.OrdersCommandServiceImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDetailsCommandServiceImpl implements OrderDetailsCommandService{

    private List<OrderDetails> orderDetails;

    public OrderDetailsCommandServiceImpl(){
        this.orderDetails=new ArrayList<>();
    }
    @Override
    public void load() {
        File file=new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\orderDetails\\data\\orderDetails.txt");
        try{
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                this.orderDetails.add(new OrderDetails(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toSave() {
        String text="";
        for(int i=0;i<this.orderDetails.size()-1;i++){
            text+=this.orderDetails.get(i).proprietati()+"\n";
        }
        text+=this.orderDetails.get(orderDetails.size()-1).proprietati();
        return text.trim();

    }

    @Override
    public void save() {
        File file=new File("C:\\mycode\\probleme\\OnlineShop\\src\\app\\orderDetails\\data\\orderDetails.txt");
        try{
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(this.toSave());
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add(OrderDetails orderDetails) {
        this.orderDetails.add(orderDetails);

    }
}
