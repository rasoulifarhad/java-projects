package com.farhad.example.design_principles02.enum_implementing_interface;

public enum Gender implements Displayable {
	
	MALE("Male"), FEMALE("Female"), PREFER_NOT_TO_SAY("PereferNotToSay");

	private String displayName;

	private Gender(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String getDisplayName() {
		return this.displayName;
	}

}
