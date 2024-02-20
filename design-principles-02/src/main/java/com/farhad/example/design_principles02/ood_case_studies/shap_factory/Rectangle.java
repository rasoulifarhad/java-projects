package com.farhad.example.design_principles02.ood_case_studies.shap_factory;

public class Rectangle implements Shap {

	@Override
	public void draw() {
		System.out.println("+-----+");
		System.out.println("|     |");
		System.out.println("+-----+");
	}

}
