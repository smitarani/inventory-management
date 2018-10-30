package service;

import java.util.List;

import org.apache.log4j.Logger;

import dao.ExceptionExample;
import dao.Operations;
import dao.OperationsImp;
import dto.InventoryDTO;

public class OperationsServiceImpl implements OperationsService {
    
	final static Logger logger = Logger.getLogger(OperationsServiceImpl.class);
	
	private Operations dao;

	public Operations getDao() {
		if (dao == null) {
			dao = new OperationsImp();
		}

		return dao;
	}

	public void setDao(Operations dao) {
		this.dao = dao;
	}

	public List<InventoryDTO> geInventoryDTO(String destinationCity) throws ExceptionExample {
		// TODO Auto-generated method stub
		return null;
	}

	public List<InventoryDTO> getItemList() throws ExceptionExample {
		// TODO Auto-generated method stub
		return null;
	}


}