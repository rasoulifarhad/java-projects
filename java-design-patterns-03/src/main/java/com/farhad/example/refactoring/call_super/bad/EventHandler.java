package com.farhad.example.refactoring.call_super.bad;

public class EventHandler {

	public void handle(BankingEvent e) {
		housekeeping(e);
	}

	private void housekeeping(BankingEvent e) {
	}
}
