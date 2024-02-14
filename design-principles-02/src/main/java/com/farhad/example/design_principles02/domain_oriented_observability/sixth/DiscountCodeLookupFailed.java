package com.farhad.example.design_principles02.domain_oriented_observability.sixth;

import lombok.Value;

@Value
public class DiscountCodeLookupFailed implements Announcement {

	private DiscountCode discountCode;
	private Exception ex;

	public DiscountCodeLookupFailed(DiscountCode discountCode, Exception ex) {
		this.discountCode = discountCode;
		this.ex = ex;
	}

}
