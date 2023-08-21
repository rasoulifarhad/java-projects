package com.farhad.example.java8idioms.functionalinterfaces;

public class FirstDemo {
	
	public static void main(String[] args) {

		threadAndRunnable();

		threadAndLambda();
	}

	private static void threadAndRunnable() {
		System.out.println();
		Thread thread = new Thread( new Runnable() {

			@Override
			public void run() {
				System.out.println("In another thread");
			}
			
		});

		thread.start();

		System.out.println("In main thread");
	}

	private static void threadAndLambda() {
		System.out.println();
		Thread thread = new Thread(() -> System.out.println("In another thread"));
		thread.start();
		System.out.println("In main thread");
	}
}
