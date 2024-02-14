package com.farhad.example.design_principles02.domain_oriented_observability.sixth;

import lombok.Value;

@Value
public class ApplyingDiscountCode implements Announcement {

	private DiscountCode discountCode;

	public ApplyingDiscountCode(DiscountCode discountCode) {
		this.discountCode = discountCode;
	}

}
