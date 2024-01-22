package com.farhad.example.functional_interface.basic.demo04;

import java.util.function.BinaryOperator;

public enum Multiply implements BinaryOperator<Integer>{	

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

	private static Integer otherMul(Integer a, Integer b) {
		return a * b;
	}

}
