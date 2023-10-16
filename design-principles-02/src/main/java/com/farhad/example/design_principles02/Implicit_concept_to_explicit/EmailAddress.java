package com.farhad.example.design_principles02.Implicit_concept_to_explicit;

import static com.farhad.example.design_principles02.good_code.ocp.Util.isTrue;

public final class EmailAddress {
	
	private final String value;

	public EmailAddress(String value) {
		isTrue(false, "Not valid email.  got: ", value);
		this.value = value;
	}

	
}
