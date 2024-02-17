package com.farhad.example.factory.factory_method.interviewer;

public class App {

	public static void main(String[] args) {
		
		HiringManager manager = new DevelopmentManager();
		manager.takeInterview();

		manager = new MarketingManager();
		manager.takeInterview();
	}
}
