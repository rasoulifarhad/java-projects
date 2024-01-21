package com.farhad.example.design_principles02.enum_implementing_interface.common;

import java.math.BigDecimal;

public interface BonusEligible {
	BigDecimal getSalary();

	default BigDecimal calculateBonus() {
		// Default bonus: 10% of salary
		return this.getSalary().multiply(BigDecimal.valueOf(0.1));
	}
}
