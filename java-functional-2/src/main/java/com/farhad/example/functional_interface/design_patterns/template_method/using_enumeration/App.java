package com.farhad.example.functional_interface.design_patterns.template_method.using_enumeration;

public class App {

	public static void main(String[] args) {
		
		TemplateClass templateClass1 = new TemplateClass(Hooks.HOOKSA);
		templateClass1.templateMethod();

		TemplateClass templateClass2 = new TemplateClass(Hooks.HOOKSB);
		templateClass2.templateMethod();
	}
}
