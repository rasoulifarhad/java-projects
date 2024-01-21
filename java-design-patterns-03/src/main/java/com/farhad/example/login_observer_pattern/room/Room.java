package com.farhad.example.login_observer_pattern.room;

import com.farhad.example.login_observer_pattern.reservation.Reservation;

public interface Room {

	String getDescription();

	double getCost();

	int getNumber();

	Reservation getReservation();

	String getRoomType();
}
