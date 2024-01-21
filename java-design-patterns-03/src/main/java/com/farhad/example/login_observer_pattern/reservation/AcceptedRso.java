package com.farhad.example.login_observer_pattern.reservation;

public class AcceptedRso implements ReservationStatusOperations {

	@Override
	public ReservationStatus accept(Reservation reservation) {
		System.out.println("Reservation already accepted!");
		return null;
	}

	@Override
	public ReservationStatus charge(Reservation reservation) {
		// charge client's credit card

		// send e-mail

		// print ticket
		
		return ReservationStatus.PAID;
	}

	@Override
	public ReservationStatus cancel(Reservation reservation) {
		// send cancellation e-mail
		return ReservationStatus.CANCELLED;
	}

}
