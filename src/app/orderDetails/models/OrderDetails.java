package app.orderDetails.models;

public class OrderDetails {
    private int id;
    private int orderId;
    private int productId;
    private int price;
    private int quantity;

    public OrderDetails(int id, int orderId, int productId, int price, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
    public OrderDetails(String text){
        String[]prop=text.split(",");
        this.id=Integer.parseInt(prop[0]);
        this.orderId=Integer.parseInt(prop[1]);
        this.productId=Integer.parseInt(prop[2]);
        this.price=Integer.parseInt(prop[3]);
        this.quantity=Integer.parseInt(prop[4]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String proprietati(){
        return id+","+orderId+","+productId+","+price+","+quantity;
    }
}
