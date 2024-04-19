package com.farhad.example.design_principles02.elegant_objects_book.method_names.declarative_vs_imperative.declarative;

public class Min extends Number {

	private final Number a;
	private final Number b;

	public Min(Number left, Number right) {
		this.a = left;
		this.b = right;
	}

	@Override
	public int intValue() {
		return a.intValue() < b.intValue() ? a.intValue() : b.intValue();
	}

	@Override
	public long longValue() {
		return a.longValue() < b.longValue() ? a.longValue() : b.longValue();
	}

	@Override
	public float floatValue() {
		return a.floatValue() < b.floatValue() ? a.floatValue() : b.floatValue();
	}

	@Override
	public double doubleValue() {
		return a.doubleValue() < b.doubleValue() ? a.doubleValue() : b.doubleValue();
	}

}
