package com.farhad.example.design_principles02.domain_oriented_observability.sixth;

import lombok.Value;

@Value
public class DiscountApplied implements Announcement {

	private DiscountCode code;

	public DiscountApplied(DiscountCode code) {
		this.code = code;
	}

}
