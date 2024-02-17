package com.farhad.example.design_principles02.successive_refinement;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringArgumentMarshaler implements ArgumentMarshaler {

	private String stringValue = "";
	
	public static String getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof StringArgumentMarshaler) {
			return ((StringArgumentMarshaler) am).stringValue;
		} else {
			return "";
		}
	}

	@Override
	public void set(Iterator<String> currentArgument) {
		try {
			stringValue = currentArgument.next();
		} catch (NoSuchElementException e) {
			throw new ArgException(ErrorCode.MISSING_STRING);
		}
	}

}
