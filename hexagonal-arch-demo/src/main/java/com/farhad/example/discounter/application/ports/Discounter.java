package com.farhad.example.discounter.application.ports;

import com.farhad.example.discounter.application.Amount;

public interface Discounter {

	public Amount calculateDiscount(Amount amount);
}

