package com.farhad.example.design_principles02.ood_case_studies.shap_factory;

public class UnknownShap implements Shap {

	@Override
	public void draw() {
		System.out.println("X     X");
		System.out.println(" X   X ");
		System.out.println("  X X  ");
		System.out.println("   X   ");
		System.out.println("  X X  ");
		System.out.println(" X   X ");
		System.out.println("X     X");
	}

}
