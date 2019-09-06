package com.metacube.facade;

import java.sql.SQLException;
import java.util.List;

import com.metacube.dao.InventoryDao;
import com.metacube.enums.Status;
import com.metacube.pojo.Inventory;

public class InventoryFacade {
	
	public static InventoryDao inventoryDao = new InventoryDao();
	
	public Status insert(String name, Integer quantity) throws SQLException {
		return inventoryDao.insert(name, quantity);
	}
	
	public Status update(String name, int quantity) throws SQLException {
		return inventoryDao.update(name, quantity);
	}
	
	public Status updateAll(String name, Inventory inventory) throws SQLException {
		return inventoryDao.updateAll(name, inventory);
	}
	
	public Status delete(String name) throws SQLException {
		return inventoryDao.delete(name);
	}
	
	public Status deleteAll() throws SQLException {
		return inventoryDao.deleteAll();
	}
	
	public Inventory getName(String name) throws SQLException {
		return inventoryDao.getName(name);
	}
	
	public List<Inventory> getAll() throws SQLException {
		return inventoryDao.getAll();
	}
}
