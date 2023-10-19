package com.farhad.example.design_principles02.dependency.four;

import java.util.UUID;

import lombok.Data;

@Data
public class User {
	private UUID userId;

	public void changePassword(String newPassword) {
	}
}
