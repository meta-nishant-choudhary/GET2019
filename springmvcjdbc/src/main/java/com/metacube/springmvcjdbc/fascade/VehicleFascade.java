package com.metacube.springmvcjdbc.fascade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.springmvcjdbc.dao.VehicleDao;
import com.metacube.springmvcjdbc.entities.Vehicle;

@Component
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
