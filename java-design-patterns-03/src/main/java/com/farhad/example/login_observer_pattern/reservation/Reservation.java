package com.farhad.example.login_observer_pattern.reservation;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter

@Setter
public class Reservation {


	private int id;
	private String name;
	private Instant date;
	private double price;
	private ReservationStatus status = ReservationStatus.NEW;

	public void accept() {
		setStatus(status.accept(this));
	}

	public void charge() {
		setStatus(status.charge(this));
	}

	public void cancel() {
		setStatus(status.cancel(this));
	}

	public void setStatus(ReservationStatus status) {
		if (status != null && status != this.status) {
			System.out.println("Reservation#" + id + ": changing status from " + this.status + " to " + status);
			this.status = status;
		}
	}
}
