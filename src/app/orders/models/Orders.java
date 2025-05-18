package app.orders.models;

public class Orders {
    private int id;
    private int  customerId;
    private int ammount;
    private String shippingAddress;
    private String  orderedDate;

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

    public String getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Orders(int id, int customerId, int ammount, String shippingAddress, String orderedDate) {
        this.id = id;
        this.customerId = customerId;
        this.ammount = ammount;
        this.shippingAddress = shippingAddress;
        this.orderedDate=orderedDate;
    }

    public Orders(String text){
        String[]prop=text.split(",");
        this.id=Integer.parseInt(prop[0]);
        this.customerId=Integer.parseInt(prop[1]);
        this.ammount=Integer.parseInt(prop[2]);
        this.shippingAddress=prop[3];
        this.orderedDate=prop[4];
    }

    public String proprietati(){
        return id+","+customerId+","+ammount+","+shippingAddress+" "+orderedDate;
    }
}
