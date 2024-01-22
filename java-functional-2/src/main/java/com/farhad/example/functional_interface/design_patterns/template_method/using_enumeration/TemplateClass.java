package com.farhad.example.functional_interface.design_patterns.template_method.using_enumeration;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TemplateClass {

	private final Hooks hooks;

	public final void templateMethod() {
		hooks.primitiveOperation1();
		hooks.primitiveOperation2();
	}
}
