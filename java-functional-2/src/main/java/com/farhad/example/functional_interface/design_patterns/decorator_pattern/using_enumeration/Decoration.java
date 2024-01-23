package com.farhad.example.functional_interface.design_patterns.decorator_pattern.using_enumeration;

public enum Decoration {

	DECORATIONA {
		@Override
		public void addedBehavior() {
			System.out.println("Added Behavior A" );
		}
	},
	DECORATIONB {
		@Override
		public void addedBehavior() {
			System.out.println("Added Behavior B");
		}
	};

	public abstract void addedBehavior();
}
