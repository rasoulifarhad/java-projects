package com.farhad.example.login_observer_pattern.room;

import com.farhad.example.login_observer_pattern.reservation.Reservation;
import com.farhad.example.login_observer_pattern.reservation.ReservationStatus;

import lombok.Getter;

@Getter
public class Room_Base implements Room {

	private String description;
	private int number;
	private double cost;
	private String roomType;
	private Reservation reservation;
	public Room_Base(String description, int number,  double cost, String roomType, Reservation reservation) {
		this.description = description;
		this.number = number;
		this.roomType = roomType;
		this.cost = cost;
		this.reservation = reservation;
		this.reservation.setStatus(ReservationStatus.NEW);

	}
	

	
	
}
