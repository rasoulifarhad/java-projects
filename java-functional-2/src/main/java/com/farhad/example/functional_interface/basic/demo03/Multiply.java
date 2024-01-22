package com.farhad.example.functional_interface.basic.demo03;

public enum Multiply {

	DIRECTMUL {
		
		@Override
		public Integer apply(Integer a, Integer b) {
			return a * b;
		}
	},
	OTHERMUL {
		@Override
		public Integer apply(Integer a, Integer b) {
			return otherMul(a, b);
		}

	};

	public abstract Integer apply(Integer a, Integer b); 

	private static Integer otherMul(Integer a, Integer b) {
		return a * b;
	}
}
