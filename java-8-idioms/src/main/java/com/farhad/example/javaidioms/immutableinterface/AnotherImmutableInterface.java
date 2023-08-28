package com.farhad.example.javaidioms.immutableinterface;

public class AnotherImmutableInterface {
	

	public static final class Point {

		public interface Immutable {
			int getX();
			int getY();
		}

		public interface Mutable extends Immutable {
			void setX(int x);
			void setY(int y);
		}
	}
}
