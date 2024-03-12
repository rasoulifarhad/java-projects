package com.farhad.example.refactoring.call_super.better;

public class TransferEventHandler extends EventHandler {


	
	@Override
	protected void doHandle(BankingEvent e) {
		initiateTransfer(e);
	}

	private void initiateTransfer(BankingEvent e) {
	}

}
