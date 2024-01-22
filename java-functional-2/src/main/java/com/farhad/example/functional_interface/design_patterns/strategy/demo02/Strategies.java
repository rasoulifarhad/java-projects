package com.farhad.example.functional_interface.design_patterns.strategy.demo02;

public enum Strategies {

	STRATEGYA {
		
		public Integer execute(Integer intVar) {
			return 10 * intVar;
		}
	},

	STRATEGYB {
		public Integer execute(Integer intVar) {
			return 100 * intVar;
		}
	};

	public abstract Integer execute(Integer intVar); 
}
