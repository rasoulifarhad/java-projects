package com.farhad.example.design_principles02.dependency.third;

import java.util.UUID;

public interface SecurityService {

	public void changePassword(UUID userId, String newPassword);
	
}
