import java.util.ArrayList;
import java.util.List;

public class Wholesaler extends Products {


    int wholesaler_id;

    String wholesaler_name;
    List <Products> product_details;

    public Wholesaler(){}
    public Wholesaler(int wholesaler_id, String wholesaler_name, List product_details) {
        this.wholesaler_id = wholesaler_id;
        this.wholesaler_name = wholesaler_name;
        this.product_details = product_details;
    }

    public int getWholesaler_id() {
        return wholesaler_id;
    }

    public void setWholesaler_id(int wholesaler_id) {
        this.wholesaler_id = wholesaler_id;
    }

    public String getWholesaler_name() {
        return wholesaler_name;
    }

    public void setWholesaler_name(String wholesaler_name) {
        this.wholesaler_name = wholesaler_name;
    }

    public List<Products> getProduct_details() {
        return product_details;
    }

    public void setProduct_details(List<Products> product_details) {
        this.product_details = product_details;
    }

    public Products get(int index) {
        return product_details.get(index);
    }

}
