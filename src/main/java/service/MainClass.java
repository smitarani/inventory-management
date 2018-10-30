package service;

import dto.InventoryDTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import dao.Operations;
import dao.OperationsImp;

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

		Operations operations = new OperationsImp();
		// TODO Auto-generated method stub
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
//			Let's just hope it works..input please
		} catch (ArrayIndexOutOfBoundsException ex1) {
			System.out.println("Invalid Arguments Passed, Truncating the Process");
		} catch (Exception e) {

			System.out.println(e.getMessage() + ", Truncating the Process");
		}

	}

}

