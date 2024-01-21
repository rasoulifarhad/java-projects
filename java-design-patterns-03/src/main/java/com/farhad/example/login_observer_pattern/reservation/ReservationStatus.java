package com.farhad.example.login_observer_pattern.reservation;

public enum ReservationStatus implements ReservationStatusOperations {

	NEW(new NewRso()),
	ACCEPTED(new AcceptedRso()),
	PAID(new PaidRso()),
	CANCELLED(new CancelledRso());
	
	private final ReservationStatusOperations operations;

	ReservationStatus(ReservationStatusOperations operations) {
		this.operations = operations;
	}

	@Override
	public ReservationStatus accept(Reservation reservation) {
		return operations.accept(reservation);
	}

	@Override

	public ReservationStatus charge(Reservation reservation) {
		return operations.charge(reservation);
	}

	@Override
	public ReservationStatus cancel(Reservation reservation) {
		return operations.cancel(reservation);
	}

	
}
