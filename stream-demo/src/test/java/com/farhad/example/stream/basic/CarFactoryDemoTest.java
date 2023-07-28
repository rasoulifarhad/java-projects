package com.farhad.example.stream.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.farhad.example.stream.basic.CarFactoryDemo.Car;
import com.farhad.example.stream.basic.CarFactoryDemo.TeslaFactory;
import com.farhad.example.stream.basic.CarFactoryDemo.VolvoFactory;

public class CarFactoryDemoTest {

	@Test
	
	public void should_build_tesla() {
		Car car = new TeslaFactory().createTesla();
		assertEquals(1000,car.engine().horsepower());
	}

	public void should_build_volvo() {
		Car car = new VolvoFactory().createCarVolvo();
		assertEquals(250, car.engine().horsepower());
	}
}
