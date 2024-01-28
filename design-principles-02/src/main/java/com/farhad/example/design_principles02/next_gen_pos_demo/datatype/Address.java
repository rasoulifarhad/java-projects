package com.farhad.example.design_principles02.next_gen_pos_demo.datatype;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;

}
