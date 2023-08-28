package com.farhad.example.javaidioms.immutableinterface;

import lombok.ToString;

// See https://wiki.c2.com/?JavaIdioms
// See https://wiki.c2.com/?ImmutableInterface
public class ImmutableInterface  {
	
	public interface ImmutablePoint {
		float getX();
		float getY();
	}

	@ToString
	public static class Point  implements ImmutablePoint {

		private float _x, _y;

		public Point(float x, float y) {
			this._x = x;
			this._y = y;
		}

		// Immutable interface
		@Override
		public float getX() {return _x;}

		@Override
		public float getY() {return _y;}

		// Mutable interface
		public void setX(float x) {this._x = x;}
		public void setY(float y) {this._y = y;}
	}

	
	@ToString
	public static class Rectangle {
		private ImmutablePoint upperLeftPoint;
		private ImmutablePoint bottomRightPoint;

		public Rectangle(float upperX, float upperY, float bottomX, float bottomY) {
			this.upperLeftPoint = new Point(upperX, upperY);
			this.bottomRightPoint = new Point(bottomX, bottomY);
		}

		public Rectangle(ImmutablePoint upper, ImmutablePoint bottom) {
			this.upperLeftPoint = upper;
			this.bottomRightPoint = bottom;
		}

		public ImmutablePoint getUpperPosition() {
			return upperLeftPoint;
		}

		public ImmutablePoint getbottomPosition() {
			return bottomRightPoint;
		}

		public void setBottomPosition(ImmutablePoint point) {
			this.bottomRightPoint = point;
		}

		public void settUpperPosition(ImmutablePoint point) {
			this.upperLeftPoint = point;
		}
	}

	public static void main(String[] args) {
		
		Rectangle rectangle = new Rectangle(1.0F, 2.0F, 3.0F,4.0F);

		ImmutablePoint upper = rectangle.getUpperPosition();
		ImmutablePoint bottom = rectangle.getbottomPosition();
		System.out.println(upper);
		System.out.println(bottom);

		((Point)upper).setX(8.0F);

		System.out.println(upper);
	}


}
