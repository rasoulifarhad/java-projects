package com.farhad.example.functional.namedfunctionsoveranonymouslambdas;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	
	private String userName;
	private String firstName;
	private String lastName;
	private Date deactivationDate;
}
