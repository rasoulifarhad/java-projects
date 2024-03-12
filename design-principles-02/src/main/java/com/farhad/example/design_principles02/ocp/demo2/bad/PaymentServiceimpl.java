package com.farhad.example.design_principles02.ocp.demo2.bad;

public class PaymentServiceimpl implements PaymentService {

	@Override
	public void pay(Payment payment) {
		if (payment.getPaymentMethod() == PaymentMethod.Cash) {
			
		} else if(payment.getPaymentMethod() == PaymentMethod.CreditCard) {

		} else if(payment.getPaymentMethod() == PaymentMethod.DebitCard) {

		} else {
			
		}
	}

}
