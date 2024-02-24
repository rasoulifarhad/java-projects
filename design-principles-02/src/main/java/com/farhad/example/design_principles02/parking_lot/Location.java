package com.farhad.example.design_principles02.parking_lot;

import lombok.Value;

@Value
public class Location {

	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String zipcode;
}
