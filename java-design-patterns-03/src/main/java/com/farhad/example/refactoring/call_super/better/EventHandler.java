package com.farhad.example.refactoring.call_super.better;

public class EventHandler {

	public void handle(BankingEvent e) {
		housekeeping(e);
		doHandle(e);
	}

	protected void doHandle(BankingEvent e) {
	}

	private void housekeeping(BankingEvent e) {
	}
}
