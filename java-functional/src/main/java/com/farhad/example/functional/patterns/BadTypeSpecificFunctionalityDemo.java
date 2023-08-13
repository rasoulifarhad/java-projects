package com.farhad.example.functional.patterns;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.farhad.example.functional.patterns.BadTypeSpecificFunctionalityDemo.BadMovieWithPriceService.Movie.Type;

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


	static class AnotherBadMovie {

		public static abstract class Movie {
			public abstract int computePrice(int days);

		}

		public static void main(String[] args) {
			
			System.out.println(new RegularMovie().computePrice(2));
			System.out.println(new NewReleaseMovie().computePrice(2));
			System.out.println(new ChildrenMovie().computePrice(2));
		}

		static class RegularMovie extends Movie {

			@Override
			public int computePrice(int days) {
				return days  + 1;
			}
		}

		static class NewReleaseMovie extends Movie {

			@Override
			public int computePrice(int days) {
				return days * 2;
			}
		}

		static class ChildrenMovie extends Movie {

			@Override
			public int computePrice(int days) {
				return 5;
			}

		}

	}


	static class BadMovieWithPriceService {

		static class Movie {
			enum  Type {
				REGULAR, NEW_RELEASE, CHILDREN;
			} 

			private final Type type;

			public Movie(Type type) {
				this.type = type;
			}
		}

		interface NewReleasePriceRepo {
			int getFactor();
		}

		static class PriceService {

			private final NewReleasePriceRepo repo;

			public PriceService(NewReleasePriceRepo repo) {
				this.repo = repo;
			}

			public int computeRegularPrice(int days) {
				return days + 1;
			}
			public int computeNewReleasePrice(int days) {
				return days * repo.getFactor();
			}
			public int computeChildrenPrice(int days) {
				return 5;
			}
			public int computePrice(Movie.Type type, int days) {
				switch (type) {
					case REGULAR:
						return computeRegularPrice(days);
					case NEW_RELEASE:
						return computeNewReleasePrice(days);
					case CHILDREN:
						return computeChildrenPrice(days);
				
					default:
						throw new IllegalArgumentException();
				}
			}
		}

		public static void main(String[] args) {
			 
			NewReleasePriceRepo repo = mock(NewReleasePriceRepo.class);
			when(repo.getFactor()).thenReturn(2);

			PriceService priceService = new PriceService(repo);
			System.out.println(priceService.computePrice(Type.REGULAR, 2)); 
			System.out.println(priceService.computePrice(Type.NEW_RELEASE, 2)); 
			System.out.println(priceService.computePrice(Type.CHILDREN, 2)); 
		}

	}

}
