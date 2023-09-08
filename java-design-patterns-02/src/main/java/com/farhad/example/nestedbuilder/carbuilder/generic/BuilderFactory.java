package com.farhad.example.nestedbuilder.carbuilder.generic;

public class BuilderFactory {
	
	public static void main(String[] args) {
		
		Parent parent = Parent.newBuilder()
								.addKidA().withNote("note for kidA").done()
								.addKidB().withNote("note for kidB").done()
							.build();
		System.out.println(parent);
	}
}
