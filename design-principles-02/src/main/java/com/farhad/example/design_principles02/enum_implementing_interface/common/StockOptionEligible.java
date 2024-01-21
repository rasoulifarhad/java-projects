package com.farhad.example.design_principles02.enum_implementing_interface.common;

import java.math.BigDecimal;

public interface StockOptionEligible {
	void processStockOptions(int numberOfOptions, BigDecimal price);
}
