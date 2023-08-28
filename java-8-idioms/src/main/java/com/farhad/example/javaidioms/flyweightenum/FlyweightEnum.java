package com.farhad.example.javaidioms.flyweightenum;

// See https://wiki.c2.com/?FlyweightEnum
public class FlyweightEnum {
	
	static class IntegerBased {
		// Use integers to represent enums
		static class  MaritalStatus {
			public static final int single = 0;
			public static final int married = 1;
			public static final int divorced = 2;
			public static final int windwed = 3;
		}
	}

	// Use flyweight objects to represent enums. A flyweight object is one that has no internal state 
	// An abstract base class represents the set; a set of derived concrete classes represents the individual members in the set. Like this: 
	static class FlyweightEnumBased {
		static abstract class MaritalStatus {
			final class Single_T extends MaritalStatus {}
			final class Married_T extends MaritalStatus {}
			final class Divorced_T extends MaritalStatus {}
			final class Windowed_T extends MaritalStatus {}

			public Single_T single = new Single_T();
			public Married_T married = new Married_T();
			public Divorced_T divorced = new Divorced_T();
			public Windowed_T windowed = new Windowed_T();
		}

		public static void main(String[] args) {
			
		}
	}

}
