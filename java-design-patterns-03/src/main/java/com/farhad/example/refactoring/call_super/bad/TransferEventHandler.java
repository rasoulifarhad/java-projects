package com.farhad.example.refactoring.call_super.bad;

public class TransferEventHandler extends EventHandler {

	@Override
	public void handle(BankingEvent e) {
		super.handle(e);
		initiateTransfer(e);
	}

	private void initiateTransfer(BankingEvent e) {
	}

}
