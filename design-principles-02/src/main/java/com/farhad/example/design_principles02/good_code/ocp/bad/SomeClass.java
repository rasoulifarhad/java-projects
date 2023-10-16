package com.farhad.example.design_principles02.good_code.ocp.bad;

public class SomeClass {
	
	public static final int TYPE_UNDEFINED = 0;
	public static final int TYPE_LEGAL_AG = 1;
	public static final int TYPE_LEGAL_PG = 2;
	public static final int TYPE_TEMPORARY = 3;
	public void someMethode() {

		boolean ok = false;

		String buildType = "LEGAL_AG";
		String prefix = "";
		int archType =1;

		switch (archType) {
			case TYPE_LEGAL_AG:
				if(buildType.equals("LEGAL_AG") || buildType.equals("LEGAL_AGPG")) {
					ok = true;
				}
				break;
			case TYPE_LEGAL_PG:
				if(buildType.equals("LEGAL_PG") || buildType.equals("LEGAL_AGPG")) {
					ok = true;
				}
				break;
			case TYPE_TEMPORARY:
				if(buildType.equals("TEMPORARY") || buildType.equals("PRV")) {
					ok = true;
				}
				prefix = "AP";
				break;
			default:
				break;
		}

		if(!ok) {
			System.out.println("Error");
		} 
	}
}
