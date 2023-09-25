package com.farhad.example.serialized_entity_pattern;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Country implements Serializable {
	
	public static final long serialVersionUID = 123654;

	private int code;
	private String name;
	private String continents;
	private String language;

}
