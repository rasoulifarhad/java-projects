package com.farhad.example.ddd_practitioner_guide.demo1.domain;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdvisingBank {
	
	@NotNull
	private final BankId id;

	@NotNull
	private final Country country;
}
