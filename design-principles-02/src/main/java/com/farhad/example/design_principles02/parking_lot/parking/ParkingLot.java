package com.farhad.example.design_principles02.parking_lot.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.farhad.example.design_principles02.parking_lot.Location;
import com.farhad.example.design_principles02.parking_lot.parkingspot.ParkingSpot;
import com.farhad.example.design_principles02.parking_lot.vehicle.Vehicle;
import com.farhad.example.design_principles02.parking_lot.vehicle.VehicleType;

public class ParkingLot {

	private static ParkingLot INSTASNCE = null; 
	private String id;

	private String name;
	private Location address;

	private Map<String, ParkingFloor> parkingFloors;
	private Map<String, EntrancePannel> entrancePannels;
	private Map<String, ExitPannel> exitPannels;
	private List<ParkingAttendantPortal> parkingAttendantPortals;
	private ParkingRate parkingRate;
	private Map<String, ParkingTicket> parkingTickets;
	
	private int handicappedSpotsCount = 0;
	private int compactSpotsCount = 0;
	private int motorbikeSpotsCount = 0;
	private int electricSpotsCount = 0;
	private int largeSpotsCount = 0;

	private int maxHandicappedCount = 0;
	private int maxCompactCount = 0;
	private int maxMotorbikeCount = 0;
	private int maxelectricCount = 0;
	private int maxLargeCount = 0;


	public ParkingLot(String name, Location address) {
		this.name = name;
		this.address = address;
		this.parkingFloors = new HashMap<>();
		this.entrancePannels = new HashMap<>();
		this.exitPannels = new HashMap<>();
		this.parkingAttendantPortals = new ArrayList<>();
		this.parkingRate = new ParkingRate();
		this.parkingFloors = new HashMap<>();
		this.parkingTickets = new HashMap<>();
	}

	public void addParkingFloor(ParkingFloor parkingFloor) {
		parkingFloors.put(parkingFloor.getFloorId(), parkingFloor);
	}

	public void addEntrancePanel(EntrancePannel entrancePannel) {
		entrancePannels.put(entrancePannel.getId(), entrancePannel);
	}

	public void addExitPanel(ExitPannel exitPannel) {
		exitPannels.put(exitPannel.getId(), exitPannel);
	}

	public ParkingTicket getNewParkingTicket(Vehicle vehicle) {
		if (isFull(vehicle.getVehicleType())) {
			throw new RuntimeException("Parking full!");
		}
		synchronized (this) {
			ParkingTicket ticket = new ParkingTicket();
			vehicle.assignTicket(ticket);
			ticket.saveInDb();
			incrementSpotCount(vehicle.getVehicleType());
			parkingTickets.put(ticket.getTicketNumber(), ticket);
		}
		
		return new ParkingTicket();
	}

	private void incrementSpotCount(VehicleType vt) {
		
		if (vt.equals(VehicleType.Truck) || vt.equals(VehicleType.Van)) {
			largeSpotsCount++;
		} else if(vt.equals(VehicleType.Motorcycle)) {
			motorbikeSpotsCount++;
		} else if (vt.equals(VehicleType.Car)) {
			if (compactSpotsCount < maxCompactCount) {
				compactSpotsCount++;
			} else {
				largeSpotsCount++;
			}
		} else {
			if(electricSpotsCount < maxelectricCount) {
				electricSpotsCount++;
			} else if(compactSpotsCount < maxCompactCount) {
				compactSpotsCount++;
			} else {
				largeSpotsCount++;
			}
		}

	}

	public boolean isFull(VehicleType vehicleType) {
		if (VehicleType.Truck.equals(vehicleType) || vehicleType.Van.equals(vehicleType)) {
			return this.largeSpotsCount >= this.maxLargeCount;
		}
		if (VehicleType.Motorcycle.equals(vehicleType)) {
			return this.motorbikeSpotsCount >= this.maxMotorbikeCount;
		}
		if (VehicleType.Car.equals(vehicleType)) {
			return (this.compactSpotsCount + this.largeSpotsCount) >= (this.maxCompactCount + this.maxLargeCount);
		}
		if (VehicleType.Electric.equals(vehicleType)) {
			return (this.electricSpotsCount + this.compactSpotsCount + this.largeSpotsCount) >= (this.maxelectricCount
					+ this.maxCompactCount + this.maxLargeCount);
		}

		return false;
	}
	
	public boolean isFull() {
		for (ParkingFloor pf : parkingFloors.values()) {
			if (!pf.isFull()) {
				return false;
			}
		}
		return true;
	}

	public void addParkingSpot(String floorName, ParkingSpot spot) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addParkingSpot'");
	}
}
