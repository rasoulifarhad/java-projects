package com.farhad.example.twin.vehicle;

public class App {
	
	public static void main(String[] args) {
		
		System.out.println("Pattern Twin, vehicle initiation sequence");

		VehicleBreaks vehicleBreaks = new VehicleBreaks();
		VehicleEngine vehicleEngine = new VehicleEngine();
		vehicleBreaks.setEngine(vehicleEngine);
		vehicleEngine.setBreaks(vehicleBreaks);

		vehicleEngine.init();
	}
}
