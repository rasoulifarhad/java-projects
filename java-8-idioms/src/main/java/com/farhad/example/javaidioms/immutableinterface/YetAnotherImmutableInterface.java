package com.farhad.example.javaidioms.immutableinterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class YetAnotherImmutableInterface {
	
	public interface Point {
		int getX();
		int getY();
	}

	public interface MutablePoint extends Point {
		void setX(final int x);
		void setY(final int y);
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class DefaultPoint implements MutablePoint {

		private int x, y;
	}
}
