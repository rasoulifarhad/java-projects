package com.farhad.example.design_principles02.good_code.ocp.good;

import java.util.HashMap;
import java.util.Map;

public class App {
	
	public static final Integer TYPE_UNDEFINED = Integer.valueOf(0);
	public static final Integer TYPE_LEGAL_AG = Integer.valueOf(1);
	public static final Integer TYPE_LEGAL_PG = Integer.valueOf(2);
	public static final Integer TYPE_TEMPORARY = Integer.valueOf(3);

	private static Map<Integer, ArchType> archTypes = new HashMap<Integer, ArchType>()
		{{
			put(TYPE_UNDEFINED, new UnDefined());
			put(TYPE_LEGAL_AG, new LegalAg());
			put(TYPE_LEGAL_PG, new LegqlPg());
			put(TYPE_TEMPORARY, new Temporary());
		}};

	public static void main(String[] args) {
		printResultFor(TYPE_LEGAL_AG, "LEGAL_AG");
		printResultFor(TYPE_LEGAL_PG, "LEGAL_PG");
		printResultFor(TYPE_TEMPORARY, "LEGAL_PG");
		printResultFor(TYPE_LEGAL_PG, "TEMPORARY");
	}

	private static void printResultFor(Integer archTypeKey, String buildType) {
		ArchType archType = archTypes.getOrDefault(archTypeKey, new UnDefined());
		System.out.println("isOk: " + archType.isOk(buildType) + ", prefix: " + archType.getPrefix() );
		
	}
}
