package com.farhad.example.design_principles02.ood_case_studies;

public class ShapFactory {

	public Shap getShap(String shapType) {
		if ("Triangle".equals(shapType)) {
			return new Triangle();
		} else if("Square".equals(shapType)) {
			return new Squre();
		} else if ("Rectangle".equals(shapType)) {
			return new Rectangle(); 
		} else {
			return new UnknownShap();
		}
	}
}
