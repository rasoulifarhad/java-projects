package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

public interface AccountingAdapter {

	public void postSale(Sale sale);

	public void postReceivable(CreditPayment creditPaymeny);
}
