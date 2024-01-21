package com.farhad.example.login_observer_pattern.reservation;

public interface ReservationStatusOperations {

	ReservationStatus accept(Reservation reservation);

	ReservationStatus charge(Reservation reservation);

	ReservationStatus cancel(Reservation reservation);

}
