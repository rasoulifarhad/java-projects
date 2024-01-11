package com.farhad.example.generic.emulating_self_types_with_generics;

import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();
		employeeBuilder.withName("name").withDepartment("Department").build();

	


		SpecialNode node2 = new SpecialNode();
		Stream<? extends SpecialNode> children2 = node2.children();
		Stream<? extends SpecialNode> grandchildren2 = children2.flatMap(child -> child.children());

	

	}
}
