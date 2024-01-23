package com.farhad.example.functional_interface.design_patterns.decorator_pattern.using_enumeration;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Decorator implements Component {

	private final Decoration decoration;
	private final Component component;
	
	@Override
	public void operation() {
		component.operation();
		decoration.addedBehavior();
		
	}
}
