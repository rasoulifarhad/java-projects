package com.farhad.example.login_observer_pattern.reservation;

public class CancelledRso implements ReservationStatusOperations {

	@Override
	public ReservationStatus accept(Reservation reservation) {
		System.out.println("Error Reservation cancelled");
		return null;
	}

	@Override
	public ReservationStatus charge(Reservation reservation) {
		System.out.println("Error you cannot charge a cancelled reservation");
		return null;
	}

	@Override
	public ReservationStatus cancel(Reservation reservation) {
		System.out.println("Room_Base already cancelled! ");
		return null;
	}
}
