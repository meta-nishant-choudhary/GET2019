package com.metacube.parkingsystem.fascade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.parkingsystem.dao.VehicleDao;
import com.metacube.parkingsystem.entities.Vehicle;

@Component
public class VehicleFascade {
	@Autowired
	private VehicleDao vehDao;
	
	public String insertVehicle(Vehicle vehicle) {
		return vehDao.insertVehicle(vehicle);
	}
	
	public int fetchVehicle() {
		return vehDao.fetchVehicle();
	}
}
