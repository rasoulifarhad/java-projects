package com.farhad.example.design_principles02.composite_design_pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Value
@Builder
public class Attribute {

	long id;
	String key;
	Object value;
}
