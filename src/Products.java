public class Products{
    private int id;
    private String name;
    private int stock;
    private int price;

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    Products(){ }
    Products(int w, String x, int y, int z){
        this.id = w;
        this.name = x;
        this.stock = y;
        this.price = z;
    }

    public void reduce_stock(int x){
        this.stock = this.stock - x;
    }

    public void reduce_stock(Products p, int x){
        p.stock = p.stock - x;
    }

    public void display(){
        System.out.println("\nProducts ---> id - "+this.id+"\tname - "+this.name+"\tstock - "+this.stock+"\tprice - "+this.price);
    }
}