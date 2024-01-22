package com.farhad.example.functional_interface.design_patterns.template_method.using_enumeration;

public enum Hooks {

	HOOKSA {

		@Override
		public void primitiveOperation1() {
			System.out.println("primitiveOperation1 called! (" + this.toString() + ")");
		}

		@Override
		public void primitiveOperation2() {
			System.out.println("primitiveOperation1 called! (" + this.toString() + ")");
		}

	},
	HOOKSB {

		@Override
		public void primitiveOperation1() {
			System.out.println("primitiveOperation1 called! (" + this.toString() + ")");
		}

		@Override
		public void primitiveOperation2() {
			System.out.println("primitiveOperation1 called! (" + this.toString() + ")");
		}

	};

	public abstract void primitiveOperation1();

	public abstract void primitiveOperation2();
}
