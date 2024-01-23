package com.farhad.example.functional_interface.design_patterns.decorator_pattern.using_enumeration_02;

public class Decorator implements Component {

	private final Component component;
	private final Decoration[] decorations;

	
	public Decorator(Component component, Decoration... decorations) {
		this.component = component;
		this.decorations = decorations;
	}


	@Override
	public void operation() {
		component.operation();
		for(Decoration decoration : decorations) {
			decoration.addedBehavior();
		}

	}

}
