package dao;

import java.util.List;

import dto.InventoryDTO;

public interface Operations {

//read from database
public List<InventoryDTO> getItemList () throws ExceptionExample;

public void create(String itemName, double costPrice, double sellingPrice);

public void delete(String itemName) throws ExceptionExample;

public void updateBuy(String itemName, int quantity);

public void updateSell(String itemName, int quantity) throws ExceptionExample;

public void report();

public void updateSellPrice(String itemName, double newSellPrice);


}
