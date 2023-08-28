package com.farhad.example.javaidioms.whetherinconstructionphase;

public class TestWhetherInConstructionPhase {
	
	static class GrandParent {

		private String name;
		public GrandParent(String name) {
			this.name = name;
			assertValid();
		}

		public void assertValid() {
			assert name == null;
		}
	}

	// Don't test your own invariant in constructors. wait until the object is complete, and 
	// then have the creator test it. If necessary use a factory method to create-and-test. 
	static class Parent extends GrandParent {
		private String grandParentName;
		public Parent(String name, String grandParentName) {
			super(name);
			this.grandParentName = grandParentName;
			assertValid();
		}

		public void assertValid() {
			super.assertValid();
			assert grandParentName == null;
		}
	}

	public static void main(String[] args) {
		// BadParent parent = new BadParent("parent", "grandparent");
		Parent parent = new Parent("parent", "grandparent");
	}
	// Constructors are executed top-down. Therefore, all myConstructionFinished fields are set to true, starting with the 
	// top one, and so on to the lowest one

	// The constructionFinished() method is 'virtual'. Therefore (and here's the crux!) when it is called, the result is 
	// always the myConstructionFinished field of the lowest class, the class that was new-ed. And that field is set to 
	// true only at the end of the lowest constructor... 

}
