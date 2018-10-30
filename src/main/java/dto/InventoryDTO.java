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
		        return "InventoryItemDTO{" +
		                "item_id=" + item_id +
		                ", item_name='" + item_name + '\'' +
		                ", cost_price=" + cost_price +
		                ", selling_price=" + selling_price +
		                ", quantity=" + quantity +
		                '}';
		    }

		public static void create(String string, Double valueOf, Double valueOf2) {
			// TODO Auto-generated method stub
			
		}

		public static void delete(String string) {
			// TODO Auto-generated method stub
			
		}

		public static void updateBuy(String string, Integer valueOf) {
			// TODO Auto-generated method stub
			
		}

		public static void updateSell(String string, Integer valueOf) {
			// TODO Auto-generated method stub
			
		}

		public static void updateSellprice(String string, Double valueOf) {
			// TODO Auto-generated method stub
			
		}

		public static void report() {
			// TODO Auto-generated method stub
			
		}

			
}	

