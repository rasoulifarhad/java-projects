package com.farhad.example.design_principles02.parking_lot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Account {

	private String userName;
	private String password;
	private Person person;
	private AccountStatus status;

	public void resetPassword() {
		
	}
}
