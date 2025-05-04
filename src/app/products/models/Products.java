package app.products.models;

public class Products {
    private int id;
    private String name;
    private int price;
    private String descriptions;
    private String  createDate;
    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getCreate_date() {
        return createDate;
    }

    public void setCreate_date(String create_date) {
        this.createDate = createDate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Products(int id, String name, int price, String descriptions, String createDate, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.descriptions = descriptions;
        this.createDate = createDate;
        this.stock = stock;
    }

    public Products(String text){
        String[]prop=text.split(",");
        this.id=Integer.parseInt(prop[0]);
        this.name=prop[1];
        this.price=Integer.parseInt(prop[2]);
        this.descriptions=prop[3];
        this.createDate=prop[4];
        this.stock=Integer.parseInt(prop[5]);
    }
    public String proprietati(){
        return id+","+name+","+price+","+descriptions+","+createDate+","+stock;
    }
}
