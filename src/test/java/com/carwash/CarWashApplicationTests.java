package com.carwash;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.carwash.model.Car;
import com.carwash.repo.CarRepository;
import com.carwash.service.CarService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CarWashApplicationTests {

	@Autowired
	private CarService carService;

	@MockBean
	private CarRepository carRepository;

	@Test
	@Order(1)
	public void getAllCarsTest() {
		when(carRepository.findAll())
				.thenReturn(Stream
						.of(new Car(101, "Bugati", "veron", "Pradumnya", "MH31 BG56"),
								new Car(102, "Bugati", "cheron", "Pradumnya", "MH31 BG57"))
						.collect(Collectors.toList()));
		assertEquals(2, carService.getAllCars().size());
	}

	@Test
	@Order(2)
	public void saveCarTest() {
		Car car = new Car(103, "Maruti", "800", "Arvind Kejrval", "MH31 BJS09");
		when(carRepository.save(car)).thenReturn(car);
		assertEquals(car, carService.saveCar(car));

	}

	@Test
	@Order(3)
	public void deleteCarTest() {
		Car car = new Car(103, "Maruti", "800", "Arvind Kejrval", "MH31 BJS09");
		carService.deleteCar(103);
		verify(carRepository, times(1)).deleteById(103);
	}
	
}
