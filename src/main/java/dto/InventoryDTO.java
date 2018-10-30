package dto;

public class InventoryDTO {


		    private int item_id;
		    private String item_name;
		    private double cost_price;
		    private double selling_price;
		    private int quantity;


		    public InventoryDTO(int item_id, String item_name, double cost_price, double selling_price, int quantity) {
		        this.item_id = item_id;
		        this.item_name = item_name;
		        this.cost_price = cost_price;
		        this.selling_price = selling_price;
		        this.quantity = quantity;
		    }

		    public int getId() {
		        return item_id;
		    }

		    public void setId(int item_id) {
		        this.item_id = item_id;
		    }

		    public String getItem_name() {
		        return item_name;
		    }

		    public void setItem_name(String item_name) {
		        this.item_name = item_name;
		    }

		    public double getCost_price() {
		        return cost_price;
		    }

		    public void setCost_price(double cost_price) {
		        this.cost_price = cost_price;
		    }

		    public double getSelling_price() {
		        return selling_price;
		    }

		    public void setSelling_price(double selling_price) {
		        this.selling_price = selling_price;
		    }

		    public int getquantity() {
		        return quantity;
		    }

		    public void setquantity(int quantity) {
		        this.quantity = quantity;
		    }

		   
		    @Override
		    public String toString() {
		    	 return   "\t"+item_name + "\t\t" + cost_price + "\t\t" + selling_price +"\t\t" + quantity ;
		    }

}	

