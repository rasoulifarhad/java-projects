package com.farhad.example.design_principles02.elegant_objects_book.method_names.declarative_vs_imperative.declarative;

public class Between extends Number {

	private final Number num;

	
	public Between(Number left, Number right, Number x) {
		this.num = new Min(new Max(left, x), right);
	}

	@Override
	public int intValue() {
		return num.intValue();
	}

	@Override
	public long longValue() {
		return num.longValue();
	}

	@Override
	public float floatValue() {
		return num.floatValue();
	}

	@Override
	public double doubleValue() {
		return num.doubleValue();
	}

	public static void main(String[] args) {
		
		System.out.println(new Between(5, 9, 13).intValue());
	}
}
