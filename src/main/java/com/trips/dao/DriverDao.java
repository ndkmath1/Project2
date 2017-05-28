package com.trips.dao;

import java.util.List;

import com.trips.entity.Driver;
import com.trips.model.DriverForm;

public interface DriverDao {

	public void saveDriver(Driver driver);
	
	public void updateDriver(Driver driver);
	
	public List<Driver> listDriver();
	
	public Driver getDriverById(int id);
	
	public void removeDriver(int id);

	
}
