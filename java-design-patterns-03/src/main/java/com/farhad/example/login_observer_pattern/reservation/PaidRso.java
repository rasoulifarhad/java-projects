package com.farhad.example.login_observer_pattern.reservation;

public class PaidRso implements ReservationStatusOperations {

	@Override
	public ReservationStatus accept(Reservation reservation) {
		System.out.println("Your reservation has already been accepted.");
		return null;
	}

	@Override
	public ReservationStatus charge(Reservation reservation) {
		System.out.println("Your reservation has already been charged.");
		return null;
	}

	@Override
	public ReservationStatus cancel(Reservation reservation) {
		if (reservation.getStatus() == ReservationStatus.PAID) {
			System.out.println("Your reservation has already been paid.");
		}
		return null;
	}

}
