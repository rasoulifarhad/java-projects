package com.farhad.example.design_principles02.enum_implementing_interface.common;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Executive extends Manager {

	    public Executive() {
        super();
    }
    
    public Executive(String name, int age, int height, int weight, String eyeColor, Gender gender,
			String taxpayerIdNumber, String employeeNumber, BigDecimal salary) {
		super(name, age, height, weight, eyeColor, gender, taxpayerIdNumber, employeeNumber, salary);
	}

	@Override
	public void processStockOptions(int numberOfOptions, BigDecimal price) {
		BigDecimal executivePrice = price.multiply(BigDecimal.valueOf(0.9)).setScale(2);

		log.info("Wow, I, " + getName() + ", can't believe I got " + numberOfOptions + " options at $"
				+ executivePrice.toPlainString() + " each!");
	}

	@Override
	public BigDecimal calculateBonus() {
		return this.getSalary().multiply(BigDecimal.valueOf(0.2));
	}
	
	
}
