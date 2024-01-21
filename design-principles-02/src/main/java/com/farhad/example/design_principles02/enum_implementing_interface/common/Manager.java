package com.farhad.example.design_principles02.enum_implementing_interface.common;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Manager extends Employee implements StockOptionEligible, BonusEligible {

	public Manager() {
		super();
	}

	public Manager(String name, int age, int height, int weight, String eyeColor, Gender gender,
			String taxpayerIdNumber, String employeeNumber, BigDecimal salary) {
		super(name, age, height, weight, eyeColor, gender, taxpayerIdNumber, employeeNumber, salary);
	}

	public Manager(String name, int age, int height, int weight, String eyeColor, Gender gender) {
		super(name, age, height, weight, eyeColor, gender);
	}


	public static Manager promote(final Employee employee) {
		Manager manager = new Manager(employee.getName(),
					employee.getAge(),
					employee.getHeight(),
                	employee.getWeight(), 
					employee.getEyeColor(), 
					employee.getGender(),
                	employee.getTaxpayerIdNumber(), 
					employee.getEmployeeNumber(), 
					employee.getSalary().multiply(BigDecimal.valueOf(1.2)).setScale(2)); // And a 20% raise!	
		return manager;
	}

	@Override
	public void processStockOptions(int numberOfOptions, BigDecimal price) {
		log.info("Wow, I, " + getName() + ", can't believe I got " + numberOfOptions + " options at $"
				+ price.toPlainString() + "each!");
	}

}
