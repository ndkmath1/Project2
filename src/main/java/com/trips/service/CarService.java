package com.trips.service;

import java.util.List;

import com.trips.entity.Car;
import com.trips.util.PaginationUtil;

public interface CarService {
	
	public void addCar(Car car);
	
	public void updateCar(Car car);
	
	public List<Car> listCar();
	
	public Car getCarById(int id);
	
	public void removeCar(int id);

	public PaginationUtil<Car> paging(int currentPage);
	
	
}
