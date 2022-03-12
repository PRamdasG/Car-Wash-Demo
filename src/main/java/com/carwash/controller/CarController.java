package com.carwash.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.model.Car;
import com.carwash.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	private CarService carService;

	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@PostMapping
	public ResponseEntity<Car> addCar(@RequestBody Car car){
		System.out.println("Order Placed");
		return new ResponseEntity<Car>(carService.saveCar(car),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Car> getAllCars(){
		return carService.getAllCars();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") int id) {
		return new ResponseEntity<Car>(carService.getCarById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Car> updateCar(@PathVariable("id") int id, @RequestBody Car car) {
		
		return new ResponseEntity<Car>(carService.updateCar(car, id), HttpStatus.OK);
		
	}
	
	
//	build delete employee REST API
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCar(@PathVariable("id") int id) {
		carService.deleteCar(id);
		return new ResponseEntity<String>("Car deleted successfully",HttpStatus.OK);
	}
}
