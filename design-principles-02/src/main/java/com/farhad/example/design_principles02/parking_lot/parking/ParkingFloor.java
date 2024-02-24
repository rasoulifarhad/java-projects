package com.farhad.example.design_principles02.parking_lot.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.farhad.example.design_principles02.apie.Vehicle;
import com.farhad.example.design_principles02.parking_lot.parkingspot.ParkingSpot;
import com.farhad.example.design_principles02.parking_lot.vehicle.VehicleType;

import lombok.Getter;

@Getter
public class ParkingFloor {

	private String floorId;

	private ParkingDisplayBoard displayBoard;
	private List<CustomerInfoPortal> customerInfoPortals;
	
	private Map<String, ParkingSpot> parkingSpots;

	private Map<String, ParkingSpot> handicappedSpots;
	private Map<String, ParkingSpot> compactSpots;
	private Map<String, ParkingSpot> motorbikeSpots;
	private Map<String, ParkingSpot> electricSpots;
	private Map<String, ParkingSpot> largeSpots;


	private int freeHandicappedSpotsCount = 0;
	private int freeCompactSpotsCount = 0;
	private int freeMotorbikeSpotsCount = 0;
	private int freeElectricSpotsCount = 0;
	private int freeLargeSpotsCount = 0;

	
	public ParkingFloor(String id) {
		this.floorId = id;
		customerInfoPortals = new ArrayList<>();

		parkingSpots = new HashMap<>();

		handicappedSpots = new HashMap<>();
		compactSpots = new HashMap<>();
		motorbikeSpots = new HashMap<>();
		electricSpots = new HashMap<>();
		largeSpots = new HashMap<>();
	}


	public void addParkingSpot(ParkingSpot spot) {
		switch (spot.getType()) {
			case Handicapped:
				handicappedSpots.put(spot.getNumber(), spot);
				break;
			case Compact:
				compactSpots.put(spot.getNumber(), spot);
				break;
			case Electric:
				electricSpots.put(spot.getNumber(), spot);
				break;
			case Large:
				largeSpots.put(spot.getNumber(), spot);
				break;
			case Motorcycle:
				motorbikeSpots.put(spot.getNumber(), spot);
				break;
			default:
				throw new IllegalArgumentException("Wrong parking spot type: "  + spot.getType());
				
		}
		
	}

	public void assignVehicleToSPOT(Vehicle vehicle, ParkingSpot spot) {

		spot.assignVehicle(vehicle);
		switch (spot.getType()) {
			case Handicapped:
				updateDisplayBoardFOrHandicapped(spot);
				break;
			case Compact:
				updateDisplayBoardForCompact(spot);
				break;
			case Electric:
				updateDisplayBoardForElectric(spot);
				break;
			case Large:
				updateDisplayBoardForLarge(spot);
				break;
			case Motorcycle:
				updateDisplayBoardForMoorcycle(spot);
				break;
			default:
				throw new IllegalArgumentException("Wrong parking spot type: " + spot.getType());
		}
	}

	private void updateDisplayBoardForMoorcycle(ParkingSpot spot) {
		if (spot.getNumber().equals(displayBoard.getMotorbikeFreeSpot().getNumber())) {
			for (String spotNumber : motorbikeSpots.keySet()) {
				if (motorbikeSpots.get(spotNumber).isFree()) {
					displayBoard.setMotorbikeFreeSpot(motorbikeSpots.get(spotNumber));
				}
			}
			displayBoard.showEmptySpotNumbers();
		}
}

	private void updateDisplayBoardForLarge(ParkingSpot spot) {
		if (spot.getNumber().equals(displayBoard.getLargeFreeSpot().getNumber())) {
			for (String spotNumber : largeSpots.keySet()) {
				if (largeSpots.get(spotNumber).isFree()) {
					displayBoard.setLargeFreeSpot(largeSpots.get(spotNumber));
				}
			}
			displayBoard.showEmptySpotNumbers();
		}
	}

	private void updateDisplayBoardForElectric(ParkingSpot spot) {
		if (spot.getNumber().equals(displayBoard.getElectricFreeSpot().getNumber())) {
			for (String spotNumber : electricSpots.keySet()) {
				if (electricSpots.get(spotNumber).isFree()) {
					displayBoard.setElectricFreeSpot(electricSpots.get(spotNumber));
				}
			}
			displayBoard.showEmptySpotNumbers();
		}
	}

	private void updateDisplayBoardForCompact(ParkingSpot spot) {
		if (spot.getNumber().equals(displayBoard.getCompactFreeSpot().getNumber())) {
			for (String spotNumber : compactSpots.keySet()) {
				if (compactSpots.get(spotNumber).isFree()) {
					displayBoard.setCompactFreeSpot(compactSpots.get(spotNumber));
				}
			}
			displayBoard.showEmptySpotNumbers();
		}
	}

	private void updateDisplayBoardFOrHandicapped(ParkingSpot spot) {
		if (spot.getNumber().equals(displayBoard.getHandicappedFreeSpot().getNumber())) {
			for (String spotNumber : handicappedSpots.keySet()) {
				if (handicappedSpots.get(spotNumber).isFree()) {
					displayBoard.setHandicappedFreeSpot(handicappedSpots.get(spotNumber));
				}
			}
			displayBoard.showEmptySpotNumbers();
		}
	}

	public void freeSpot(ParkingSpot spot) {

		spot.removeVehicle();
		switch (spot.getType()) {
			case Handicapped:
				freeHandicappedSpotsCount += 1;
				break;
			case Compact:
				freeCompactSpotsCount += 1;
				break;
			case Electric:
				freeElectricSpotsCount += 1;
				break;
			case Large:
				freeLargeSpotsCount += 1;
				break;
			case Motorcycle:
				freeMotorbikeSpotsCount += 1;
				break;
			default:
				throw new IllegalArgumentException("Wrong parking spot type: " + spot.getType());
		}

	}

	public boolean IsFullFor(VehicleType vt) {

		switch (vt) {
			case Truck:
				return freeLargeSpotsCount <= 0;
			case Van:
				return freeLargeSpotsCount <= 0;
			case Motorcycle:
				return freeMotorbikeSpotsCount <= 0;
			case Car:
				return freeCompactSpotsCount <= 0 && freeLargeSpotsCount <= 0;
			case Electric:
				return freeElectricSpotsCount <= 0 && freeCompactSpotsCount <= 0 && freeLargeSpotsCount <= 0;
			default:
				throw new IllegalArgumentException("Wrong vehicle type: " + vt);
		}

	}


	public boolean isFull() {
		if (freeLargeSpotsCount > 0) {
			return false;
		}
		if (freeCompactSpotsCount > 0) {
			return false;
		}
		if (freeElectricSpotsCount > 0) {
			return false;
		}
		if (freeMotorbikeSpotsCount > 0) {
			return false;
		}
		return true;
	}
}
