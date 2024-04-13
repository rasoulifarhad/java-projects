package com.farhad.example.design_principles02.video_store_demo;

public class App {

	public static void main(String[] args) {
		

		Movie newRelease1;
		Movie newRelease2;
		Movie childrens;
		Movie regular1;
		Movie regular2;
		Movie regular3;

		newRelease1 = new NewReleaseMovie("New Release 1");
		newRelease2 = new NewReleaseMovie("New Release 2");
		childrens = new ChildrensMovie("Childrens");
		regular1 = new RegularMovie("Regular 1");
		regular2 = new RegularMovie("Regular 2");
		regular3 = new RegularMovie("Regular 3");
		
		Customer customer = new Customer("customer");

		customer.addRental(new Rental(regular1, 1));
		customer.addRental(new Rental(regular2, 2));
		customer.addRental(new Rental(regular3, 3));
		customer.addRental(new Rental(childrens, 3));
		customer.addRental(new Rental(newRelease1, 3));
		customer.addRental(new Rental(newRelease2, 3));

		System.out.println(customer.statement());
		System.out.println();
		System.out.println(customer.htmlStatement());
	}
}
