package service;


import java.util.List;

import dao.ExceptionExample;
import dto.InventoryDTO;

	public interface OperationsService {	 
		public List<InventoryDTO> getItemList () throws ExceptionExample;
		
	}

