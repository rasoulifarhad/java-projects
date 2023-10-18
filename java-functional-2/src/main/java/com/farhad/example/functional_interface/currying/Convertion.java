package com.farhad.example.functional_interface.currying;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class Convertion {

	public static void main(String[] args) {

		double result = convert(10, 1.8, 32);
		System.out.println(result);

		double cInF = convert(10, 1.8, 32);
		System.out.println("cInF: " + cInF);
		
		double higherTemp = convert(30, 1.8, 32);
		System.out.println("higherTemp: " + higherTemp);

		// currency
		double dollarsInPounds = convert(10, 0.6, 0);
		System.out.println( "dollarsInPounds: " + dollarsInPounds);

		// distance
		double koilometersInMiles = convert(27, 0.62137, 0);
		System.out.println("koilometersInMiles: " + koilometersInMiles);

		dollarsInPounds = convert1(1.8, 0).applyAsDouble(10);
		System.out.println( "dollarsInPounds: " + dollarsInPounds);

		higherTemp = convert1(1.8, 32).applyAsDouble(30);
		System.out.println("higherTemp: " + higherTemp);

		DoubleUnaryOperator convertCtoF = convert1(1.8, 32);
		double cToF10 = convertCtoF.applyAsDouble(10);
		System.out.println("cToF10: " + cToF10);

		DoubleUnaryOperator convert$ToPound = convert1(0.6, 10);
		DoubleUnaryOperator convertKmToMi = convert1(0.62137, 0);

		IntFunction<IntUnaryOperator> add = curry((left, right) -> left + right);
		result = add.apply(1).applyAsInt(2);
		System.out.println(result);
	}

	// int -> (int -> int)
	static IntFunction<IntUnaryOperator> curry(IntBinaryOperator biFunction) {
		return f ->  (s -> biFunction.applyAsInt(f, s) );
	}
	

	static double convert(double amount, double factor, double base) {
		return amount * factor + base;
	}

	static DoubleUnaryOperator convert1(double factor, double base) {
		return amount -> amount * factor + base;
	}

}
