package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.InventoryDTO;

	public class OperationsImp implements Operations {

	    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	    static final String DB_URL = "jdbc:mysql://localhost:33060/inventory_management";

	    //  Database credentials
	    static final String USER = "root";
	    static final String PASSWORD = "simmi@0502";

	    Connection conn = null;
	    Statement statement = null;
	    
	    List<InventoryDTO> itemList;
	    static double profit = 0;

	    public List<InventoryDTO> getItemList() {

	        //SELECT * FROM inventory.item_details;
	        itemList = new ArrayList<InventoryDTO>();

	        try{
	            //STEP 2: Register JDBC driver
	            try {
					Class.forName(JDBC_DRIVER);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            //STEP 3: Open a connection
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
	            //STEP 4: Execute a query
	            System.out.println("Creating statement...");
	            statement = conn.createStatement();
	            String sql;
	            sql = "SELECT * FROM inventory_management.item_details;";
	            System.out.println(sql);
	            System.out.println(sql);
	            ResultSet rs = statement.executeQuery(sql);

	            //STEP 5: Extract data from result set
	            while(rs.next()){
	                //Retrieve by column name
	                int item_id  = rs.getInt("item_id");
	                String item_name = rs.getString("item_name");
	                double cost_price = rs.getDouble("cost_price");
	                double selling_price = rs.getDouble("selling_price");
	                int quantity = rs.getInt("quantity");
	                InventoryDTO inventoryItemDTO = new InventoryDTO(item_id, item_name, cost_price, selling_price, quantity);
	                itemList.add(inventoryItemDTO);
	                //Display values
	                System.out.println("Item Id: " + item_id +", Name: " + item_name+ ", Cost Price: " + cost_price + ", Selling Price: " + selling_price+", Quantity: " +quantity);
	            }
	            //STEP 6: Clean-up environment
	            rs.close();
	            statement.close();
	            conn.close();
	        }catch(SQLException se){
	            //Handle errors for JDBC
	            se.printStackTrace();
	        }finally{
	            //finally block used to close resources
	            try{
	                if(statement!=null)
	                    statement.close();
	            }catch(SQLException se2){
	            }// nothing we can do
	            try{
	                if(conn!=null)
	                    conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }//end finally try
	        }//end try
	        return itemList;
	    }

	    public void create(String itemName, double costPrice, double sellingPrice) {

	        try{
	            //STEP 2: Register JDBC driver
	            Class.forName(JDBC_DRIVER);
	            //STEP 3: Open a connection
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
	            //STEP 4: Execute a query
	            System.out.println("Creating statement...");
	            statement = conn.createStatement();

	            String sql;
	            sql = "INSERT INTO `inventory_management`.`item_details` (`item_name`,`cost_price`,`selling_price`,`quantity`)\n" +
	                    "VALUES \n" +
	                    "( '" +itemName +"',"+costPrice +"," + sellingPrice +"," + 0 +");";
	            System.out.println(sql);

	            System.out.println(sql);
	             statement.executeUpdate(sql);

	            statement.close();
	            conn.close();
	        }catch(SQLException se){
	            //Handle errors for JDBC
	            se.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally{
	            //finally block used to close resources
	            try{
	                if(statement!=null)
	                    statement.close();
	            }catch(SQLException se2){
	            }// nothing we can do
	            try{
	                if(conn!=null)
	                    conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }//end finally try
	        }//end try

	    }

	    public void delete(String itemName) throws ExceptionExample {

	        for (int i=0; i<itemList.size(); i++) {

	            if(itemList.get(i).getItem_name().equalsIgnoreCase(itemName)){
	                profit =profit + (itemList.get(i).getSelling_price()-itemList.get(i).getCost_price())
	                        * itemList.get(i).getquantity();
	            }else{
	                throw new ExceptionExample("Item not found" +itemName);
	            }
	        }

	        try{
	            //STEP 2: Register JDBC driver
	            Class.forName(JDBC_DRIVER);
	            //STEP 3: Open a connection
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
	            //STEP 4: Execute a query
	            System.out.println("Creating statement...");
	            statement = conn.createStatement();

	            String sql;
	            sql = "DELETE FROM inventory_management.item_details \n" +
	                    "WHERE item_name ='"+itemName+"';";
	            System.out.println(sql);

	            System.out.println(sql);
	            statement.executeUpdate(sql);

	            statement.close();
	            conn.close();
	        }catch(SQLException se){
	            //Handle errors for JDBC
	            se.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally{
	            //finally block used to close resources
	            try{
	                if(statement!=null)
	                    statement.close();
	            }catch(SQLException se2){
	            }// nothing we can do
	            try{
	                if(conn!=null)
	                    conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }//end finally try
	        }//end try
	    }

	    public void updateBuy(String itemName, int quantity) {

	        try{
	            //STEP 2: Register JDBC driver
	            Class.forName(JDBC_DRIVER);
	            //STEP 3: Open a connection
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
	            //STEP 4: Execute a query
	            System.out.println("Creating statement...");
	            statement = conn.createStatement();

	            String sql;
	            sql = "UPDATE inventory_management.item_details \n" +
	                    "SET quantity = "+quantity+" WHERE item_name Like '"+itemName+"';";

	            System.out.println(sql);
	            statement.executeUpdate(sql);

	            statement.close();
	            conn.close();
	        }catch(SQLException se){
	            //Handle errors for JDBC
	            se.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally{
	            //finally block used to close resources
	            try{
	                if(statement!=null)
	                    statement.close();
	            }catch(SQLException se2){
	            }// nothing we can do
	            try{
	                if(conn!=null)
	                    conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }//end finally try
	        }//end try

	    }

	    public void updateSell(String itemName, int quantity) throws ExceptionExample {

	        for (int i=0; i<itemList.size(); i++) {

	            if(itemList.get(i).getItem_name().equalsIgnoreCase(itemName)){
	                profit = profit + (itemList.get(i).getSelling_price()-itemList.get(i).getCost_price())
	                        * quantity ;
	            }else{
	                throw new ExceptionExample("Item not found" +itemName);
	            }
	        }

	        try{
	            //STEP 2: Register JDBC driver
	            Class.forName(JDBC_DRIVER);
	            //STEP 3: Open a connection
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
	            //STEP 4: Execute a query
	            System.out.println("Creating statement...");
	            statement = conn.createStatement();

	            String sql;
	            sql = "UPDATE inventory_management.item_details \n" +
	                    "SET quantity = "+quantity+" WHERE item_name Like '"+itemName+"';";
	            System.out.println(sql);
	            statement.executeUpdate(sql);

	            statement.close();
	            conn.close();
	        }catch(SQLException se){
	            //Handle errors for JDBC
	            se.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally{
	            //finally block used to close resources
	            try{
	                if(statement!=null)
	                    statement.close();
	            }catch(SQLException se2){
	            }// nothing we can do
	            try{
	                if(conn!=null)
	                    conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }//end finally try
	        }//end try

	    }

	    public void report() {

	        double total_value = 0;
	        System.out.println("***INVENTORY REPORT***");
	        for (InventoryDTO item:itemList) {
	            double value = item.getCost_price() * item.getquantity();
	            System.out.println(item.toString()+" value" +value);
	            total_value = total_value + value;
	        }

	        System.out.println("Total Value"+ total_value);
	        System.out.println("Profit since previous report"+ profit);

	        profit = 0;
	    }

	    public void updateSellPrice(String itemName, double newSellPrice) {
	        System.out.println("Profit before sells price update");
	        report();

	        try{
	            //STEP 2: Register JDBC driver
	            Class.forName(JDBC_DRIVER);
	            //STEP 3: Open a connection
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
	            //STEP 4: Execute a query
	            System.out.println("Creating statement...");
	            statement = conn.createStatement();

	            String sql;
	            sql = "UPDATE inventory_management.item_details \n" +
	                    "SET selling_price = "+newSellPrice+" WHERE item_name Like '"+itemName+"';";
	            System.out.println(sql);
	            statement.executeUpdate(sql);

	            statement.close();
	            conn.close();
	        }catch(SQLException se){
	            //Handle errors for JDBC
	            se.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally{
	            //finally block used to close resources
	            try{
	                if(statement!=null)
	                    statement.close();
	            }catch(SQLException se2){
	            }// nothing we can do
	            try{
	                if(conn!=null)
	                    conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }//end finally try
	        }//end try

	        getItemList();
	        report();


	    }

	}


