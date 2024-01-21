package com.farhad.example.design_principles02.enum_implementing_interface.common;

import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {

	private String taxpayerIdNumber;
	private String employeeNumber;
	private BigDecimal salary;
	
	
	public Employee(String name, int age, int height, int weight, String eyeColor, Gender gender) {
		super(name, age, height, weight, eyeColor, gender);
	}

	public Employee(String name, int age, int height, int weight, String eyeColor, Gender gender,
			String taxpayerIdNumber, String employeeNumber, BigDecimal salary) {
		super(name, age, height, weight, eyeColor, gender);
		this.taxpayerIdNumber = taxpayerIdNumber;
		this.employeeNumber = employeeNumber;
		this.salary = salary;
	}

	@Override
	public void printAudit(StringBuffer buffer) {
		super.printAudit(buffer);

		buffer.append("TaxpayerIdentificatioNumber=");
		buffer.append(getTaxpayerIdNumber());
		buffer.append(",");
		buffer.append("EmployeeNumber=");
		buffer.append(getEmployeeNumber());
		buffer.append(",");
		buffer.append("Salary=");
		buffer.append(getSalary().setScale(2).toPlainString());
	}
	
	
}
