package com.farhad.example.ddd_tips.another_ddd.domain.model.security;

public interface Security {
	User user();

	// Security.generateSecurityException(“You are not allowed to view this clients details.”);
	public static void generateSecurityException(String message) {
		throw new RuntimeException(message);
	}
}
