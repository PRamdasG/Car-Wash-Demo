package com.carwash.service;

import java.util.List;

import com.carwash.model.Car;

public interface CarService {

	Car saveCar(Car car);
	List<Car> getAllCars();
	Car getCarById(int id);
	Car updateCar(Car car, int id);
	void deleteCar(int id);
	
}
