package com.farhad.example.java8idioms.functionalinterfaces;

import java.util.function.Consumer;

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

	static class DeviceDemo {

		interface Device {
			void checkin();
			void checkout();
		}

		public void borrowDevice(Consumer<Device> use) {
			Device device = getFromAvailable();
			device.checkout();
			try {
				use.accept(device);
			} finally {
				device.checkin();
			}
		}

		private Device getFromAvailable() {
			return new Device() {

				@Override
				public void checkin() {
					System.out.println("Checkin device");
				}

				@Override
				public void checkout() {
					System.out.println("Checkout device");
				}

				@Override
				public String toString() {
					return "Unknown device";
				}
				
			};
		}

		public static void main(String[] args) {
			new DeviceDemo().borrowDevice(device -> System.out.println("Using " + device) );
		}
	}

}
