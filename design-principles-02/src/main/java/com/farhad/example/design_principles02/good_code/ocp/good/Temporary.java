package com.farhad.example.design_principles02.good_code.ocp.good;

public class Temporary implements ArchType{

	@Override
	public boolean isOk(String buildType) {
		return buildType.equals("TEMPORARY") || buildType.equals("PRV");
	}

	@Override
	public String getPrefix() {
		return "AG";
	}
	
}
