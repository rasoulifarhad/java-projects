package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.isp.good;

public interface OnlineOrderProcessor {

	boolean validateCardInfo(CreditCardInfo info);
}
