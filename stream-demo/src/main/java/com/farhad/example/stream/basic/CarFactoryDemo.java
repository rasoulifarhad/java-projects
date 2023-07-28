package com.farhad.example.stream.basic;

import static org.apache.commons.lang3.Validate.notNull;

import java.util.function.Function;

public class CarFactoryDemo {
	
	public interface Alternator {

	}

	public interface Car {
		Engine engine();
	}	

	public interface Engine {
		int horsepower();
	}

	public interface CarFactory {
		Alternator alternator();
	}

	public static class GenericCarFactory implements CarFactory {

		private final Function<CarFactory, Engine> engineStrategy;

		private GenericCarFactory(final Function<CarFactory, Engine> engineStrategy) {
			this.engineStrategy = notNull(engineStrategy);
		}

		public static Car createCarWith(final Function<CarFactory, Engine> engineStrategy) {
			final Engine engine = engineStrategy.apply(new GenericCarFactory(engineStrategy)); 
			return new GenericCar(engine);
		}

		@Override
		public Alternator alternator() {
			Engine engine = engineStrategy.apply(this);
			return engine.horsepower() > 400 ? new BadAssAlternator() : new NormalAlternator();
		}

	}

	private static final class GenericCar implements Car {

		private final Engine engine;

		public GenericCar(final Engine engine) {
			this.engine = notNull(engine);
		}

		@Override
		public Engine engine() {
			return engine;
		}	

	}

	private static final class BadAssAlternator implements Alternator {}

	private static final class NormalAlternator implements Alternator{}

	public static class TeslaFactory {

		public Car createTesla() {
			return GenericCarFactory.createCarWith(factory -> engine(factory));
		}

		private Engine engine(final CarFactory carFactory) {
			return new TeslaEngin();
		}
		private static final class TeslaEngin implements Engine {

			@Override
			public int horsepower() {
				return 1000;
			}
			
		}
	}

	public static class VolvoFactory {

		public Car createCarVolvo() {
			return GenericCarFactory.createCarWith(factory -> engine(factory));
		}
		private Engine engine(final CarFactory factory) {
			return new VolvoEngine();
		}
		private static final class VolvoEngine implements Engine {

			@Override
			public int horsepower() {
				return 250;
			}
			
		}
	}
}
