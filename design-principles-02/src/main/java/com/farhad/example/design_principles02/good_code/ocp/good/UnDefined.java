package com.farhad.example.design_principles02.good_code.ocp.good;

public class UnDefined implements ArchType {

	@Override
	public boolean isOk(String buildType) {
		return  false;
	}

	@Override
	public String getPrefix() {
		return "";
	}
	
}
