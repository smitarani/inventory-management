package service;

import dto.InventoryDTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import dao.Operations;
import dao.OperationsImp;

public class MainClass {
	
  	public static void main(String[] args) {

		OperationsImp operations = new OperationsImp();
		
 
	    System.out.println("Enter the operation:");
	    System.out.println("Add : CREATE");
	    System.out.println("Delete item : DELETE");
	    System.out.println("Update buy quantity : UPDATEBUY");
	    System.out.println("Update sold quantity : UPDATESELL");
	    System.out.println("Get report : REPORT");

	    Scanner scanner = new Scanner(System.in);
	    String  x;
	    int quantity;
	    String itemName;
	    double costPrice;
	    double sellPrice;


	        System.out.println("Enter operation you want to perform :");
	        x = scanner.nextLine().toUpperCase();
	        switch (x) {

	            case "CREATE":
	                System.out.println("Enter item name");
	                itemName = scanner.nextLine();
	                System.out.println("Enter cost price");
	                costPrice = scanner.nextDouble();
	                System.out.println("Enter sell price");
	                sellPrice = scanner.nextDouble();
	                try {
	                    operations.create(itemName, costPrice, sellPrice);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }

	                break;

	            case "DELETE":
	                System.out.println("Enter item name for delete");
	                itemName = scanner.nextLine();
	                try {
	                    operations.delete(itemName);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                break;

	            case "UPDATEBUY":
	                System.out.println("Enter item name");
	                itemName = scanner.nextLine();
	                System.out.println("Enter bought item number");
	                quantity = scanner.nextInt();
	                try {
	                    operations.updateBuy(itemName, quantity);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                break;

	            case "UPDATESELL":
	                System.out.println("Enter item name for delete");
	                itemName = scanner.nextLine();
	                System.out.println("Enter sold item number");
	                quantity = scanner.nextInt();
	                try {
	                    operations.updateSell(itemName, quantity);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                break;

	            case "REPORT":
	                //System.out.println("********REPORT***********");
	                try {
	                    operations.report();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                break;

	        	 default:
	                System.out.println("Invalid input");
	                break;
	        }
  	}
}


		 
		 
		 
    /*//Define Command Variables
	private static final String createCmd = "CREATE";
	private static final String deleteCmd = "DELETE";
	private static final String updateBuyCmd = "UPDATEBUY";
	private static final String updateSellCmd = "UPDATESELL";
	private static final String reportCmd = "REPORT";
	private static final String updateSellPriceCmd = "UPDATESELLPRICE";
	static {
		System.gc();
	}
	try {
			Scanner scanner = new Scanner(System.in);
			String lineText = scanner.nextLine();

			while (!lineText.equals("q")) {
				String[] commands = lineText.split(" ");
				String command = commands[0];
				if (createCmd.equalsIgnoreCase(command)) {
					operations.create(commands[1], Double.valueOf(commands[2]), Double.valueOf(commands[3]));
				} else if (deleteCmd.equalsIgnoreCase(command)) {
					operations.delete(commands[1]);
				} else if (updateBuyCmd.equalsIgnoreCase(command)) {
					operations.updateBuy(commands[1], Integer.valueOf(commands[2]));
				} else if (updateSellCmd.equalsIgnoreCase(command)) {
					operations.updateSell(commands[1], Integer.valueOf(commands[2]));
				} else if (updateSellPriceCmd.equalsIgnoreCase(command)) {
					operations.updateSellPrice(commands[1], Double.valueOf(commands[2]));
				} else if (reportCmd.equalsIgnoreCase(command)) {
					operations.report();
				} else {
					System.out.println("Invalid Command ");
				}

				lineText = scanner.nextLine();
			}
			scanner.close();
			
		} catch (ArrayIndexOutOfBoundsException ex1) {
			System.out.println("Invalid input, Truncating the Process");
		} catch (Exception e) {

			System.out.println(e.getMessage() + ", Truncating the Process");
		}

	} */
