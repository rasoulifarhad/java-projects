package com.farhad.example.functional.patterns;

// See https://dzone.com/articles/functional-programming-patterns-with-java-8
public class BadTypeSpecificFunctionalityDemo {
	
	static class BadMovie {

		enum Type {
			REGULAR, NEW_RELEASE, CHILDREN;
		}

		private final Type type;

		public BadMovie(Type type) {
			this.type = type;
		}

		public int computePrice(int days) {
			switch (type) {
				case REGULAR:
					return days + 1;	
				case NEW_RELEASE:
					return days * 2;	
				case CHILDREN:
					return 5;	
			
				default:
					throw new IllegalArgumentException();
			}
		}

		public static void main(String[] args) {
			
			System.out.println(new BadMovie(Type.REGULAR).computePrice(2));
			System.out.println(new BadMovie(Type.NEW_RELEASE).computePrice(2));
			System.out.println(new BadMovie(Type.CHILDREN).computePrice(2));
		}

	}


	static abstract class AnotherBadMovie {
		public abstract int computePrice(int days);

		public static void main(String[] args) {
			
			System.out.println(new RegularAnotherBadMovie().computePrice(2));
			System.out.println(new NewReleaseAnotherBadMovie().computePrice(2));
			System.out.println(new ChildrenAnotherBadMovie().computePrice(2));
		}
	}

	static class RegularAnotherBadMovie extends AnotherBadMovie {

		@Override
		public int computePrice(int days) {
			return days  + 1;
		}
	}

	static class NewReleaseAnotherBadMovie extends AnotherBadMovie {

		@Override
		public int computePrice(int days) {
			return days * 2;
		}
	}

	static class ChildrenAnotherBadMovie extends AnotherBadMovie {

		@Override
		public int computePrice(int days) {
			return 5;
		}

	}

}
