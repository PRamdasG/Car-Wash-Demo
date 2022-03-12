package com.carwash.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.model.Car;

public interface CarRepository extends MongoRepository<Car, Integer>{
	Optional<Car> findByCarModel(String carModel);
}
