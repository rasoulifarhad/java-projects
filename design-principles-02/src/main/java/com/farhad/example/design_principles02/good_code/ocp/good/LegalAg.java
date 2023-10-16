package com.farhad.example.design_principles02.good_code.ocp.good;

public class LegalAg implements ArchType {

	@Override
	public boolean isOk(String buildType) {
		return buildType.equals("LEGAL_AG") || buildType.equals("LEGAL_AGPG");
	}

	@Override
	public String getPrefix() {
		return "";
	}
	
}
