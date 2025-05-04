package app.orders.models;

public class Orders {
    private int id;
    private int  customerId;
    private int ammount;
    private String shippingAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Orders(int id, int customerId, int ammount, String shippingAddress) {
        this.id = id;
        this.customerId = customerId;
        this.ammount = ammount;
        this.shippingAddress = shippingAddress;
    }

    public Orders(String text){
        String[]prop=text.split(",");
        this.id=Integer.parseInt(prop[0]);
        this.customerId=Integer.parseInt(prop[1]);
        this.ammount=Integer.parseInt(prop[2]);
        this.shippingAddress=prop[3];
    }

    public String proprietati(){
        return id+","+customerId+","+ammount+","+shippingAddress;
    }
}
