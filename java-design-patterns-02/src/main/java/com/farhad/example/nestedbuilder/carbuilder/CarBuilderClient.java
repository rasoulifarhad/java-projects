package com.farhad.example.nestedbuilder.carbuilder;

import java.util.List;

public class CarBuilderClient {
	
	public static void main(String[] args) {
		Engine engine = Engine.newBuilder().withPower(100).withType(5).build();
		Wheel wheel1 = Wheel.newBuilder().withSize(4).withColor(3).withType(2).build();
		Wheel wheel2 = Wheel.newBuilder().withSize(4).withColor(3).withType(2).build();
		Wheel wheel3 = Wheel.newBuilder().withSize(4).withColor(3).withType(2).build();
		Wheel wheel4 = Wheel.newBuilder().withSize(4).withColor(3).withType(2).build();

		// List<Wheel> wheels = Arrays.asList(
		// 	wheel1,
		// 	wheel2,
		// 	wheel3);

		List<Wheel> wheels = WheelListBuilder.newBuilder().withNewList().addWheel(wheel1).addWheel(wheel2).addWheel(wheel3).addWheel(wheel4).build();

		Car car = Car.newBuilder().withEngine(engine).withWheels(wheels).builde();

		System.out.println("Car: " + car);
	}
}
