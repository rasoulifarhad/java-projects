package com.farhad.example.design_principles02.dependency.second;

import java.util.UUID;

import lombok.Data;

@Data
public class User {
	private UUID userId;

	public void changePassword(String newPassword) {
	}
}
