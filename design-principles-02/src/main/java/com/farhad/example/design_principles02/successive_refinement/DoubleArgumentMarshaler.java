package com.farhad.example.design_principles02.successive_refinement;

import static com.farhad.example.design_principles02.successive_refinement.ErrorCode.INVALID_DOUBLE;
import static com.farhad.example.design_principles02.successive_refinement.ErrorCode.MISSING_DOUBLE;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleArgumentMarshaler implements ArgumentMarshaler {

	private double doubleValue = 0.0;
	public static double getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof DoubleArgumentMarshaler) {
			return ((DoubleArgumentMarshaler) am).doubleValue;
		} else {
			return 0.0;
		}
	}

	@Override
	public void set(Iterator<String> currentArgument) {
		String parameter = null;
		try {
			parameter = currentArgument.next();
			doubleValue = Double.parseDouble(parameter);
		} catch (NoSuchElementException e) {
			throw new ArgException(MISSING_DOUBLE);
		} catch (NumberFormatException e) {
			throw new ArgException(INVALID_DOUBLE, parameter);
		}
	}

}
