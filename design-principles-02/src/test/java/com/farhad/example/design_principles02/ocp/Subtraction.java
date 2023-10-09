package com.farhad.example.design_principles02.ocp;

public class Subtraction extends BinaryOperations {

	public Subtraction(int operand1, int operand2) {
		super(operand1, operand2);
	}

	@Override
	public int result() {
		return getOperand1() - getOperand2();
	}
	
}
