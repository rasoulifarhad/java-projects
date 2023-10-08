package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

import java.util.List;

public interface UserApplicationService {
	
	UserDTO create(UserCreationDTO input);
	UserDTO update(UserUpdateDTO input);
	void changePassword(UserChangePasswordDTO input);

	UserDTO getById(String userId);
	List<UserDTO> getList();

	// UserDTO getById(String userId);
	// List<UserNameAndEmailDTO> getUsernameAndEmail(String userId);
	// List<String> getRoles(String userId);
	// List<UserListDTO> getList();
	// UserCreateResultDTO create(UserCreationDTO input);
	// UserUpdateResultDTO create(UserUpdateDTO input);

	
}
