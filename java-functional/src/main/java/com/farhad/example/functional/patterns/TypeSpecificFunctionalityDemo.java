package com.farhad.example.functional.patterns;

import java.util.function.BiFunction;

public class TypeSpecificFunctionalityDemo {
	

	static class Movie {

		enum Type {
			REGULAR(PriceService::computeRegularPrice),
			NEW_RELEASE(PriceService::computeNewReleasePrice),
			CHILDREN(PriceService::computeChildrenPrice);

			final BiFunction<PriceService, Integer, Integer> priceAlgo;
			private Type(BiFunction<PriceService, Integer, Integer> priceAlgo) {
				this.priceAlgo = priceAlgo;
			}
		}

		private final Type type;

		public Movie(Type type) {
			this.type = type;
		}
	}

	interface NewReleasePriceRepository {
		double getFactor();
	}

	static class PriceService {

		private final NewReleasePriceRepository repository;

		public PriceService(NewReleasePriceRepository repository) {
			this.repository = repository;
		}

		int computeNewReleasePrice(int days) {
			return (int) (days * repository.getFactor()); 
		}

		int computeRegularPrice(int days) {
			return days + 1;
		}

		int computeChildrenPrice(int days) {
			return 5;
		}

		public int computePrice(Movie.Type type, int days) {
			return type.priceAlgo.apply(this, days);
		}
	}

}
