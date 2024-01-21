package com.farhad.example.login_observer_pattern.room;

import com.farhad.example.login_observer_pattern.reservation.Reservation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Room_Template implements Room {

	protected final Room templ_room;

	@Override
	public double getCost() {
		return templ_room.getCost();
	}

	@Override
	public String getDescription() {
		return templ_room.getDescription();
	}

	@Override
	public int getNumber() {
		return templ_room.getNumber();
	}

	@Override
	public Reservation getReservation() {
		return templ_room.getReservation();
	}

	@Override
	public String getRoomType() {
		return templ_room.getRoomType();
	}

	
}
