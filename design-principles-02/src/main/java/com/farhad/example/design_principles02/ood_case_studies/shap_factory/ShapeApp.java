package com.farhad.example.design_principles02.ood_case_studies.shap_factory;

public class ShapeApp {

	public static void main(String[] args) {
		
		ShapFactory sf = new ShapFactory();
		
		Shap shap;
		
		shap = sf.getShap("Rectangle");
		shap.draw();

		shap = sf.getShap("Triangle");
		shap.draw();

		shap = sf.getShap("Square");
		shap.draw();

		shap = sf.getShap("noooooo");
		shap.draw();
	}
}
