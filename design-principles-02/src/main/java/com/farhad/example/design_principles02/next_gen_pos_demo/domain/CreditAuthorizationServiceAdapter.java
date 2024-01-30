package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

public interface CreditAuthorizationServiceAdapter {

	public void requestApproval(CreditPayment creditPayment, TerminalId terminalId, MerchantId merchantId);
}
