package com.farhad.example.creational_patterns_demo.incentive_module;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class Amount {
	
	private final BigDecimal value;
}
