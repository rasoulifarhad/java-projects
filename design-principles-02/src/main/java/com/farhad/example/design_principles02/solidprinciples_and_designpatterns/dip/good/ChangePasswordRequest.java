package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.dip.good;

import lombok.Value;

@Value
public class ChangePasswordRequest {

	private String userName;
	private String oldPassword;
	private String newPassword;
}
