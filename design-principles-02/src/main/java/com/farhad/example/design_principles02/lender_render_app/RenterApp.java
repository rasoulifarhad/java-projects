package com.farhad.example.design_principles02.lender_render_app;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RenterApp {

	private final Lender lender;
	private final Renter renter;

	public void action(String actionType) {
		if ("rent".equals(actionType)) {
			rentCommand();
		} else if ("return".equals(actionType)) {
			returnCommand();
		} else {
			throw new IllegalArgumentException("Unknown action: " + actionType);
		}
	}



	private void displayQtyOnHand() {
		System.out.println(lender.getQtyOnHand());
	}

	private void rentCommand() {
		lender.rentItem(renter);
		displayQtyOnHand();
	}

	private void returnCommand() {
		lender.rentItem(renter);
		displayQtyOnHand();
	}

	public static void main(String[] args) {
		
		Lender lender = new Lender(5);
		Renter renter = new Renter();
		RenterApp renterApp = new RenterApp(lender, renter);

		renterApp.action("rent");

		renterApp.action("rent");

		renterApp.action("return");
		renterApp.action("rent");
		renterApp.action("rent");
		renterApp.action("rent");
	}
	
}
