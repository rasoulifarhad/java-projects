package com.farhad.example.design_principles02.polymorphic_behavior_through_inheritance;

public class App {

	public static void main(String[] args) {

		BusinessContact bc = new BusinessContact();
		bc.setFirstName("Business name");
		bc.setLastName("Business family");
		bc.setEmailAddress("businessEmail1@example.com");
		bc.setPhoneNo("98999999999");
		bc.setCompanyName("Company 01");
		bc.setDesignation("Designation 01");
		showDetails(bc);

		ProfessionalContact pc = new ProfessionalContact();
		pc.setFirstName("Professional name");
		pc.setLastName("Professional family");
		pc.setEmailAddress("professionalEmail01@example.com");
		pc.setAddress("Professional address");
		pc.setPhoneNo("9888888888");
		pc.setService("Professional service");
		pc.setTiming("Professional timing");
		showDetails(pc);
	}
	
	public static void showDetails(Contact c) {
		System.out.println(c.getDetails());
	}
}
