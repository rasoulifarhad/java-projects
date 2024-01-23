package com.farhad.example.functional_interface.design_patterns.decorator_pattern.standard_oop;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Decorator implements Component {

	private final Component component;

	@Override
	public void operation() {
		component.operation();
	}
}
