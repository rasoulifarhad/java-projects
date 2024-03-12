package com.farhad.example.design_principles02.ocp.demo2.good;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentServiceimpl implements PaymentService {

	private final PaymentMethod paymentMethod;
	@Override
	public void pay(Payment payment) {
		paymentMethod.pay(payment);
	}

}
