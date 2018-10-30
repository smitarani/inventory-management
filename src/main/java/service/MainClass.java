package service;

import dto.InventoryDTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

			public class MainClass {
			// Define Command Variables
				private static final String createCmd = "CREATE";
				private static final String deleteCmd = "DELETE";
				private static final String updateBuyCmd = "UPDATEBUY";
				private static final String updateSellCmd = "UPDATESELL";
				private static final String reportCmd = "REPORT";
				private static final String updateSellPriceCmd = "UPDATESELLPRICE";
				static {
					System.gc();
				}

				public static void main(String[] args) throws FileNotFoundException, IOException {

					// TODO Auto-generated method stub
					try {
						Scanner scanner = new Scanner(System.in);
						String lineText = null;
						while (true) {
							System.out.print("Enter command,'q' to quit :");
							// Read User input value
							//lineText = scanner.nextLine();
							if ("q".equalsIgnoreCase(lineText)) {
								System.out.println("Exit!");
								break;
							}
							boolean commands = scanner.hasNext(createCmd);
							String command = commands[0];
							if (createCmd.equalsIgnoreCase(command)) {
								InventoryDTO.create(commands[1], Double.valueOf(commands[2]), Double.valueOf(commands[3]));
							} else if (deleteCmd.equalsIgnoreCase(command)) {
								InventoryDTO.delete(commands[1]);
							} else if (updateBuyCmd.equalsIgnoreCase(command)) {
								InventoryDTO.updateBuy(commands[1], Integer.valueOf(commands[2]));
							} else if (updateSellCmd.equalsIgnoreCase(command)) {
								InventoryDTO.updateSell(commands[1], Integer.valueOf(commands[2]));
							} else if (updateSellPriceCmd.equalsIgnoreCase(command)) {
								InventoryDTO.updateSellprice(commands[1], Double.valueOf(commands[2]));
							} else if (reportCmd.equalsIgnoreCase(command)) {
								InventoryDTO.report();
							} else {
								System.out.println("Invalid Command ");
							}
						}
						scanner.close();
				

					} catch (ArrayIndexOutOfBoundsException ex1) {
						System.out.println("Invalid Arguments Passed, Truncating the Process");
					} catch (Exception e) {

						System.out.println(e.getMessage() + ", Truncating the Process");
					}

				}

			}
		  /* OperationsImp inventoryList = new OperationsImp();

		   System.out.println("Print All the items list");

		        inventoryList.getItemList();

		     System.out.println("Add one item to the list");

		    inventoryList.create("Book02", 1.00, 2.0);

		    System.out.println("Update item in the list");

		    inventoryList.updateBuy("Book02", 5);

		    System.out.println("Delete the item form the list");

		    try {
		        inventoryList.delete("Book02");
		    } catch (ExceptionExample e) {
		        e.printStackTrace();
		    }

		    System.out.println("Inventory Report");

		    inventoryList.report();

		    System.out.println("Updated Inventory report");

		    inventoryList.updateSellPrice("BOOK02", 8);
		}
	}
*/
