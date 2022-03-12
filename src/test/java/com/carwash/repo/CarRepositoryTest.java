package com.carwash.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.Rollback;

import com.carwash.model.Car;

@DataMongoTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarRepositoryTest {

	@Autowired
	private CarRepository carRepository;
	
//	JUnit test for save Product
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveProductTest() {
		Car car = new Car(101, "Mercedes", "Benz", "Pradumnya Ghadole", "MH31 BF8086");
		carRepository.save(car);
		
		assertThat(car.getId()).isGreaterThan(0);
		
	}
	
	@Test
	@Order(2)
	@Rollback(value = false)
	public void getProductByIdTest() {
		Car car = carRepository.findById(1).get();
		assertThat(car.getId()).isEqualTo(1);
	}
	
	@Test
	@Order(3)
	@Rollback(value = false)
	public void getAllProductsTest() {
		List<Car> car = carRepository.findAll();
		assertThat(car.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateProductTest() {
		Car car = carRepository.findById(1).get();
		car.setCarNumber("MH31 BF8087");
		Car carUpdated = carRepository.save(car);
		assertThat(carUpdated.getCarNumber()).isEqualTo("MH31 BF8087");
	}
	
	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteProductTest() {
		Car car = carRepository.findById(1).get();
		carRepository.delete(car);
//		carRepository.deleteById(1);
		Car car1 = null;
		Optional<Car> car2 = carRepository.findByCarModel("Benz");
		if (car2.isPresent()) {
			car1 = car2.get();
		}
		assertThat(car1).isNull();
	}
	
}
