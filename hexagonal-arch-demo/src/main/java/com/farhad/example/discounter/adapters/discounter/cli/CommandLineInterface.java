package com.farhad.example.discounter.adapters.discounter.cli;

import java.util.Scanner;

import com.farhad.example.discounter.adapters.Driver;
import com.farhad.example.discounter.application.Amount;
import com.farhad.example.discounter.application.ports.Discounter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandLineInterface implements Driver {

	private final Discounter discounterApp;
	
	@Override
	public void run(String... args) {
		System.out.println("============================");
		System.out.println("Running CLI");
		System.out.println("============================");
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			printAppMenu();	
			try {
				String option = scanner.next();
				switch (option) {
					case "1":
						option1(scanner);
						break;
					case "2":
						exit = true;
						break;
				
					default:
						System.out.println("Invalid option");
						break;
				}
			} catch (Exception e) {
				System.out.println("Unexpected error");
				e.printStackTrace();
			}
		}
	}

	private void option1(Scanner scanner) {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Enter an amount:");
		String amount = scanner.next();
		System.out.println("The discount is : ");
		Amount discount = discounterApp.calculateDiscount(Amount.parse(amount));
		System.out.println(discount.toString());

	}

	private void printAppMenu() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("-------------------");
		System.out.println("DISCOUNTER APP MENU");
		System.out.println("-------------------");
		System.out.println("(1) Calculate discount.");
		System.out.println("(2) Exit.");
		System.out.println("Choose an option:");	
	}
 
}
