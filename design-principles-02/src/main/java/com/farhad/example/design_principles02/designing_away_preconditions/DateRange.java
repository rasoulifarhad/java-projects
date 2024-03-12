package com.farhad.example.design_principles02.designing_away_preconditions;

import java.time.LocalDate;
import java.util.Objects;


public class DateRange {

	private LocalDate start;
	private LocalDate end;

	public DateRange(LocalDate start, LocalDate end) {
		Objects.requireNonNull(start);
		Objects.requireNonNull(end);
		if (!end.isAfter(start)) {
			throw new IllegalArgumentException("End date must be after start date");
		}
		this.start = start;
		this.end = end;
	}

	public DateRange(LocalDate start, int extentInDays) {
		Objects.requireNonNull(start);
		if (extentInDays < 0) {
			throw new IllegalArgumentException("extent in days must be positive.");
		}

		this.start = start;
		this.end = start.plusDays(extentInDays);
	}

	public DateRange(LocalDate start) {
		Objects.requireNonNull(start);
		this.start = start;
		this.end = start;
	}

	public void addWeek() {
		this.end = this.end.plusWeeks(1);
	}

	public void addDay() {
		this.end = this.end.plusDays(1);
	}

	public static DateRange daysFrom(LocalDate start, int days) {
		return new DateRange(start, days);
	}
}
