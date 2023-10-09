package com.farhad.example.design_principles02.ocp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class BinaryOperations {
	
	protected int operand1;
	protected int operand2;

	public abstract int result();
}
