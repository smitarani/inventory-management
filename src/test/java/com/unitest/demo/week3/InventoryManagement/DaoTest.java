package com.unitest.demo.week3.InventoryManagement;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.OperationsImp;
import dto.InventoryDTO;

public class DaoTest {


	    private int item_id;
	    private String item_name;
	    private double cost_price;
	    private double selling_price;
	    private int quantity;
	    
		OperationsImp operationsImpl;
		
		InventoryDTO itemList;
		
		 @Before //Executed before each test. It is used to prepare the test environment
		    public void setUp() {
		        System.out.println("Inside @Before");
		        operationsImpl = new OperationsImp();
		        item_id = 2;
		        item_name = "Food01";
		        cost_price = 1.74;
		        selling_price = 3.98;
		      
		        
		       
		    }
		 
		   
		   @Test
		    public void testDAO(){
		        System.out.println("Inside testItem()");
		        List<InventoryDTO> testItem = null;
				try {
					testItem = operationsImpl.getItemList();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.println(testItem.size());
		        
		        assertEquals(4, testItem.size());
		        
		        assertEquals(2, testItem.get(1).getId());
		        assertEquals("Food01", testItem.get(1).getItem_name());
		        assertEquals(1.74, testItem.get(1).getCost_price(), 0);
		        assertEquals(3.98, testItem.get(1).getSelling_price(), 0);
		        
		        
		   }
		   
		   
		  @Test
		    public void testNoDAOFound() {
		    	List<InventoryDTO> testItem = null;
				testItem = operationsImpl.getItemList();
		    	assertEquals(4, testItem.size());
		  }
		
	}

