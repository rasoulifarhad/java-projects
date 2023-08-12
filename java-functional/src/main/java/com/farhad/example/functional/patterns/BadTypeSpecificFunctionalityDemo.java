package com.farhad.example.functional.patterns;

import com.farhad.example.functional.patterns.BadTypeSpecificFunctionalityDemo.Movie.Type;

public class BadTypeSpecificFunctionalityDemo {
	
	static class Movie {

		enum Type {
			REGULAR, NEW_RELEASE, CHILDREN;
		}

		private final Type type;

		public Movie(Type type) {
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
	}

	public static void main(String[] args) {
		
		System.out.println(new Movie(Type.REGULAR).computePrice(2));
		System.out.println(new Movie(Type.NEW_RELEASE).computePrice(2));
		System.out.println(new Movie(Type.CHILDREN).computePrice(2));

	}
}
