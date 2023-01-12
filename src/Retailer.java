import java.util.List;
public class Retailer extends Wholesaler {

    public Retailer(int retailer_id, String retailer_name, List<Wholesaler> wholesaler_details) {
        this.retailer_id = retailer_id;
        this.retailer_name = retailer_name;
        this.wholesaler_details = wholesaler_details;
    }

    int retailer_id;
    String retailer_name;
    List<Wholesaler> wholesaler_details;


    public int getRetailer_id() {
        return retailer_id;
    }

    public void setRetailer_id(int retailer_id) {
        this.retailer_id = retailer_id;
    }

    public String getRetailer_name() {
        return retailer_name;
    }

    public void setRetailer_name(String retailer_name) {
        this.retailer_name = retailer_name;
    }

    public List<Wholesaler> getWholesaler_details() {
        return wholesaler_details;
    }

    public void setWholesaler_details(List<Wholesaler> wholesaler_details) {
        this.wholesaler_details = wholesaler_details;
    }




}
