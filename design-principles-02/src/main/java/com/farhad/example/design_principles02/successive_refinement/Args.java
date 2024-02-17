package com.farhad.example.design_principles02.successive_refinement;

import static com.farhad.example.design_principles02.successive_refinement.ErrorCode.INVALID_ARGUMENT_FORMAT;
import static com.farhad.example.design_principles02.successive_refinement.ErrorCode.INVALID_ARGUMENT_NAME;
import static com.farhad.example.design_principles02.successive_refinement.ErrorCode.UNEXPECTED_ARGUMENT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class Args {

	Map<Character, ArgumentMarshaler> marshalers;
	Set<Character> argsFound;
	private ListIterator<String> currentArgument;

	public Args(String schema, String[] args) {
		marshalers = new HashMap<>();
		argsFound = new HashSet<>();
		parseSchema(schema);
		parseArgumentStrings(Arrays.asList(args));
	}

	private void parseSchema(String schema) {
		for (String element : schema.split(",")) {
			if (element.length() > 0) {
				parseSchemaElement(element.trim());
			}
		}
	}

	private void parseSchemaElement(String element) {
		char elementId = element.charAt(0);
		String elementTail = element.substring(1);
		validateSchemaElementId(elementId);
		if (elementTail.length() == 0) {
			marshalers.put(elementId, new BooleanArgumentMarshaler());
		} else if (elementTail.equals("*")) {
			marshalers.put(elementId, new StringArgumentMarshaler());
		} else if (elementTail.equals("#")) {
			marshalers.put(elementId, new IntegerArgumentMarshaler());
		} else if (elementTail.equals("##")) {
			marshalers.put(elementId, new DoubleArgumentMarshaler());
		} else if (elementTail.equals("[*]")) {
			marshalers.put(elementId, new StringArrayArgumentMarshaler());
		} else {
			throw new ArgException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
		}
	}

	private void validateSchemaElementId(char elementId) {
		if (!Character.isLetter(elementId)) {
			throw new ArgException(INVALID_ARGUMENT_NAME, elementId, null);
		}
	}

	private void parseArgumentStrings(List<String> argsList) {
		for (currentArgument = argsList.listIterator(); currentArgument.hasNext();) {
			String argString = currentArgument.next();
			if (argString.startsWith("-")) {
				parseArgumentCharacters(argString.substring(1));
			} else {
				currentArgument.previous();
				break;
			}
		}
	}

	private void parseArgumentCharacters(String argChars) {
		for (int i = 0; i < argChars.length(); i++) {
			parseArgumentCharacter(argChars.charAt(i));
		}
	}

	private void parseArgumentCharacter(char argChar) {
		ArgumentMarshaler m = marshalers.get(argChar);
		if (m == null) {
			throw new ArgException(UNEXPECTED_ARGUMENT, argChar, null);
		} else {
			argsFound.add(argChar);
			try {
				m.set(currentArgument);
			} catch (ArgException e) {
				e.setErrorArgumentId(argChar);
				throw e;
			}
		}
	}

	public boolean has(char arg) {
		return argsFound.contains(arg);
	}
	
	public int nextArgement() {
		return currentArgument.nextIndex();
	}



	public boolean getBoolean(char arg) {
		return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
	}

	public String getString(char arg) {
		return StringArgumentMarshaler.getValue(marshalers.get(arg));
	}

	public int getInt(char arg) {
		return IntegerArgumentMarshaler.getValue(marshalers.get(arg));
	}

	public double getDouble(char arg) {
		return DoubleArgumentMarshaler.getValue(marshalers.get(arg));
	}

	public String[] getStringArray(char arg) {
		return StringArrayArgumentMarshaler.getValue(marshalers.get(arg));
	}

}
