package com.farhad.example.design_principles02.successive_refinement;

import static com.farhad.example.design_principles02.successive_refinement.ErrorCode.INVALID_INTEGER;
import static com.farhad.example.design_principles02.successive_refinement.ErrorCode.MISSING_INTEGER;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {

	private int intValue = 0;

	public static int getValue(ArgumentMarshaler argumentMarshaler) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getValue'");
	}

	@Override
	public void set(Iterator<String> currentArgument) {
		String parameter = null;
		try {
			parameter = currentArgument.next();
			intValue = Integer.parseInt(parameter);
		} catch (NoSuchElementException e) {
			throw new ArgException(MISSING_INTEGER);
		} catch (NumberFormatException e) {
			throw new ArgException(INVALID_INTEGER, parameter);
		}
	}

}
