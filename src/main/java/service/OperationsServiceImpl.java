package service;

import java.util.List;

import org.apache.log4j.Logger;

import dao.ExceptionExample;
import dao.Operations;
import dao.OperationsImp;
import dto.InventoryDTO;

public class OperationsServiceImpl implements OperationsService {
    
	final static Logger logger = Logger.getLogger(OperationsServiceImpl.class);
	
	Operations dao;

	public Operations getDao() {
		if (dao == null) {
			dao = new OperationsImp();
		}

		return dao;
	}

	public void setDao(Operations dao) {
		this.dao = dao;
	}

	public List<InventoryDTO> getItemList() {

        List<InventoryDTO> itemList = null;

        try {
            itemList = getDao().getItemList();
        } catch (ExceptionExample e) {

            logger.error(e);
        }


        return itemList;
	}


}