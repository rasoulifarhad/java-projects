package com.farhad.example.design_principles02.elegant_objects_book.method_names;

public class Max extends Number {

	private final Number a;
	private final Number b;

	
	public Max(Number left, Number right) {
		this.a = left;
		this.b = right;
	}

	@Override
	public int intValue() {
		return a.intValue() > b.intValue() ? a.intValue() : b.intValue();
	}

	@Override
	public long longValue() {
		return a.longValue() > b.longValue() ? a.longValue() : b.longValue();
	}

	@Override
	public float floatValue() {
		return a.floatValue() > b.floatValue() ? a.floatValue() : b.floatValue();
	}

	@Override
	public double doubleValue() {
		return a.doubleValue() > b.doubleValue() ? a.doubleValue() : b.doubleValue();
	}

	public static void main(String[] args) {
		
		Number x = new Max(5, 9);

		System.out.println(x.intValue());
	}

}
