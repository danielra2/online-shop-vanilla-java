package app.orderDetails.services;

import app.orderDetails.models.OrderDetails;
import app.orders.models.Orders;
import app.orders.services.OrdersService;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDetailsService {
    private List<OrderDetails>orderDetails;
    private OrdersService ordersService;

    public OrderDetailsService(){
        ordersService=new OrdersService();
        orderDetails=new ArrayList<>();
        load();
    }
    public void load(){
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
    public String toSave(){
        String text="";
        for(int i=0;i<this.orderDetails.size()-1;i++){
            text+=this.orderDetails.get(i).proprietati()+"\n";
        }
        text+=this.orderDetails.get(orderDetails.size()-1).proprietati();
        return text.trim();
    }
    public void Save(){
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
    public void add(OrderDetails orderDetails){
        this.orderDetails.add(orderDetails);
    }
    //todo: iau toate comenzile care au un anumit id,fac lista cu id ului

    public List<OrderDetails>getAllOrderDetailsByOrderId(int orderId){
        List<OrderDetails>searchedDetails= new ArrayList<>();
        for(int i=0;i<orderDetails.size();i++){
            if(orderDetails.get(i).getOrderId()==orderId){
                searchedDetails.add(orderDetails.get(i));
            }
        }
        return searchedDetails;
    }
    public int getNextOrderDetailId(){
        if(orderDetails.isEmpty()){
            return 1;
        }
        int maxId=0;
        for(int i=0;i<orderDetails.size();i++){
            if(orderDetails.get(i).getId()>maxId){
                maxId=orderDetails.get(i).getId();
            }
        }
        return maxId+1;
    }
}
