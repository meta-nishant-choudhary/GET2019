package com.metacube.hibernate1.fascade;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.hibernate1.dao.VehicleDao;
import com.metacube.hibernate1.entities.Vehicle;

@Service
@Transactional
public class VehicleFascade {
	
	@Autowired
	private VehicleDao vehDao;
	
	public void insertVehicle(Vehicle vehicle) {
		vehDao.insertVehicle(vehicle);
	}
	
	public int fetchVehicle() {
		return vehDao.fetchVehicle();
	}
}
