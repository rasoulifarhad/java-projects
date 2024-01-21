package com.farhad.example.login_observer_pattern;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class User {

	protected String username;
	protected String password;
	protected String userType;
	protected String passportNo;
	protected String address;
	protected String telephone;

	public User(String username, String password, String userType) {
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	

}
