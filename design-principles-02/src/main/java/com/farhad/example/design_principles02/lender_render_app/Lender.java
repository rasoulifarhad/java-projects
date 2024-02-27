package com.farhad.example.design_principles02.lender_render_app;

import lombok.Getter;

public class Lender {

	@Getter
	private int qtyOnHand;

	
	public Lender(int initialQty) {
		this.qtyOnHand = initialQty;
	}

	public boolean rentItem(Renter renter) {
		if (qtyOnHand > 0) {
			qtyOnHand--;
			renter.tellResult("Thanks for your business- come back soon.");
			return true;
		}
		renter.tellResult("Oops -- we’re all out of bugs just now. Can I interest you in a worm or a virus?");
		return false;
	}

	public void returnItem(Renter renter) {
		qtyOnHand++;
		renter.tellResult("Thanks for returning the bug promptly.");
	}

	public void displayQtyOnHand() {
		System.out.println(qtyOnHand);
	}

}
