package com.farhad.example.design_principles02.parking_lot.parking;

import com.farhad.example.design_principles02.parking_lot.parkingspot.ParkingSpot;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParkingDisplayBoard {

	private String id;

	private ParkingSpot handicappedFreeSpot;
	private ParkingSpot compactFreeSpot;
	private ParkingSpot largeFreeSpot;
	private ParkingSpot motorbikeFreeSpot;
	private ParkingSpot electricFreeSpot;

	
	public ParkingDisplayBoard(String id) {
		this.id = id;
	}


	public void showEmptySpotNumbers() {
		StringBuilder sb = new StringBuilder();

		sb = handicappedFreeSpot.isFree() ? sb.append("Free Handicapped: ").append(handicappedFreeSpot.getNumber()) : sb.append("Handicapped is full");
		sb = sb.append("\n");

		sb = compactFreeSpot.isFree() ? sb.append("Free Compact: ").append(compactFreeSpot.getNumber()) : sb.append("Compact is full");
		sb = sb.append("\n");

		sb = largeFreeSpot.isFree() ? sb.append("Free Large: ").append(largeFreeSpot.getNumber()) : sb.append("Large is full");
		sb = sb.append("\n");

		sb = motorbikeFreeSpot.isFree() ? sb.append("Free Motorbike: ").append(motorbikeFreeSpot.getNumber()) : sb.append("Motorbike is full");
		sb = sb.append("\n");

		sb = electricFreeSpot.isFree() ? sb.append("Free Electric: ").append(electricFreeSpot.getNumber()) : sb.append("Electric is full");
		sb = sb.append("\n");

		System.out.println(sb.toString());

	}

}
