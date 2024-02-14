package com.farhad.example.design_principles02.domain_oriented_observability.sixth;

import lombok.Value;

@Value
public class DiscountCodeLookupSucceeded implements Announcement {

	private DiscountCode discountCode;

	public DiscountCodeLookupSucceeded(DiscountCode discountCode) {
		this.discountCode = discountCode;
	}

}
