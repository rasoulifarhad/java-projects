package com.farhad.example.design_principles02.good_code.ocp.good;

public class LegqlPg implements ArchType {

	@Override
	public boolean isOk(String buildType) {
		return buildType.equals("LEGAL_PG") || buildType.equals("LEGAL_AGPG");
	}

	@Override
	public String getPrefix() {
		return "";
	}
	
}
