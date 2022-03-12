	package com.carwash.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carwash.exception.ResourceNotFoundException;
import com.carwash.model.Car;
import com.carwash.repo.CarRepository;
import com.carwash.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	private CarRepository carRepository;

	public CarServiceImpl(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	@Override
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public Car getCarById(int id) {
		return carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
	}

	@Override
	public Car updateCar(Car car, int id) {
		Car existingOrders = carRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));

		existingOrders.setId(car.getId());
		existingOrders.setCarCompany(car.getCarCompany());
		existingOrders.setCarModel(car.getCarModel());
		existingOrders.setCarNumber(car.getCarNumber());
		existingOrders.setOwnerName(car.getOwnerName());


		carRepository.save(existingOrders);

		return existingOrders;
	}

	@Override
	public void deleteCar(int id) {
		carRepository.deleteById(id);
	}

}
