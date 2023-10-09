package com.farhad.example.private_methods;

interface InefficientTennis {

	static void forehand() {
		System.out.println("Move into position");
		System.out.println("Hitting a forehand");
		System.out.println("Move back into ready position");
	}

	default void backhand() {
		System.out.println("Move into position");
		System.out.println("Hitting a backhand");
		System.out.println("Move back into ready position");
	}

	default void smash() {
		System.out.println("Move into position");
		System.out.println("Hitting a smash");
		System.out.println("Move back into ready position");
	}
}

interface EfficientTennis {
	static void hit(String stroke) {
		System.out.println("Move into position");
		System.out.println("Hitting a " + stroke);
		System.out.println("Move back into ready position");
	}

	default void backhand() {
		hit("backhand");
	}
	default void forehand() {
		hit("forehand");
	}
	static void smash() {
		hit("smash");
	}

}

public class SportDemo implements EfficientTennis {

	public static void main(String[] args) {
		new SportDemo().backhand();
		EfficientTennis.smash();
	}
}
