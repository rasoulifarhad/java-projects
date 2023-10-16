package com.farhad.example.design_principles02.good_code.ocp.bad;

public class App {
	
	public static final int TYPE_UNDEFINED = 0;
	public static final int TYPE_LEGAL_AG = 1;
	public static final int TYPE_LEGAL_PG = 2;
	public static final int TYPE_TEMPORARY = 3;

	public static void main(String[] args) {
		
		printResultFor(TYPE_LEGAL_AG, "LEGAL_AG");
		printResultFor(TYPE_LEGAL_PG, "LEGAL_PG");
		printResultFor(TYPE_TEMPORARY, "LEGAL_PG");
		printResultFor(TYPE_LEGAL_PG, "TEMPORARY");

	}

	private static void printResultFor(int archType, String buildType) {
		
		boolean isOk = false;
		String prefix = "";
		switch (archType) {
			case TYPE_LEGAL_AG:
				if(buildType.equals("LEGAL_AG") || buildType.equals("LEGAL_AGPG")) {
					isOk = true;
				}
				break;
			case TYPE_LEGAL_PG:
				if(buildType.equals("LEGAL_PG") || buildType.equals("LEGAL_AGPG")) {
					isOk = true;
				}
				break;
			case TYPE_TEMPORARY:
				if(buildType.equals("TEMPORARY") || buildType.equals("PRV")) {
					isOk = true;
				}
				prefix = "AP";
				break;
			default:
				break;
		}
		
		System.out.println("isOk: " + isOk + ", prefix: " + prefix );

	}

}
