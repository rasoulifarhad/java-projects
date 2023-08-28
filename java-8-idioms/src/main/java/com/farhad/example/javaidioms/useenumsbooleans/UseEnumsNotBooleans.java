package com.farhad.example.javaidioms.useenumsbooleans;

import lombok.ToString;

// https://wiki.c2.com/?UseEnumsNotBooleans
public class UseEnumsNotBooleans {
	
	@ToString(onlyExplicitlyIncluded = true)
	static class MoveBooleanBased {
		private static float MAX_POSITION = 1024.0F;
		private static float MIN_POSITION = 1.0F;
		
		@ToString.Include
		float position;

		@ToString.Include
		boolean movingUp = false;

		public void move(float amount) {
			if(movingUp) {
				moveUp(amount);	

			} else {
				moveDown(amount);
			}
		}

		public void moveUp(float amount) {
			position += amount;
			if(position > MAX_POSITION) {
				position = MAX_POSITION;
				movingUp = false;
			}
		}

		public void moveDown(float amount) {
			position -= amount;
			if(position < MIN_POSITION) {
				position = MIN_POSITION;
				movingUp = true;
			}
		}

		public static void main(String[] args) {
			MoveBooleanBased move = new MoveBooleanBased();
			System.out.println(move);
			move.move(10.0F);
			System.out.println(move);
			move.move(20.0F);
			System.out.println(move);
			move.move(15.0F);
		}
	}

	@ToString(onlyExplicitlyIncluded = true)
	static class MoveEnumBased {

		enum Direction {
			MOVING_UP, MOVING_DOWN; 
		}
		private static float MAX_POSITION = 1024.0F;
		private static float MIN_POSITION = 1.0F;
		
		@ToString.Include
		float position;

		@ToString.Include
		Direction direction = Direction.MOVING_DOWN;

		public void move(float amount) {
			switch (direction) {
				case MOVING_DOWN:
					moveDown(amount);
					break;
				case MOVING_UP:
					moveUp(amount);	
					break;
				default:
					break;
			}
		}

		public void moveUp(float amount) {
			position += amount;
			if(position > MAX_POSITION) {
				position = MAX_POSITION;
				direction = Direction.MOVING_DOWN;
			}
		}

		public void moveDown(float amount) {
			position -= amount;
			if(position < MIN_POSITION) {
				position = MIN_POSITION;
				direction = Direction.MOVING_UP;
			}
		}

		public static void main(String[] args) {
			MoveEnumBased move = new MoveEnumBased();
			System.out.println(move);
			move.move(10.0F);
			System.out.println(move);
			move.move(20.0F);
			System.out.println(move);
			move.move(15.0F);
		}
	}
}
