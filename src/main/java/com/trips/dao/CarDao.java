package com.trips.dao;

import java.util.List;

import com.trips.entity.Car;
import org.hibernate.Query;

public interface CarDao {
	
	public void addCar(Car car);
	
	public void updateCar(Car car);
	
	public List<Car> listCar();
	
	public Car getCarById(int id);
	
	public void removeCar(int id);

	public Query getQuery();
	
}
