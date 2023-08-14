package com.farhad.example.functional.namedfunctionsoveranonymouslambdas;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

// See https://dzone.com/articles/functional-programming-patterns-with-java-8
@RequiredArgsConstructor
public class UserServiceDemo {
	
	private final UserRepository repository;

	public List<UserDto> getAllUsersOldWay() {
		
		List<User> users = repository.findAll();
		List<UserDto> dtos = new ArrayList<>();
		for (User user : users) {
			UserDto dto = new UserDto();
			dto.setUserName(user.getUserName());
			dto.setFullName(String.format("%s %s", user.getFirstName(), user.getLastName()));
			dto.setActive(user.getDeactivationDate() == null);
			dtos.add(dto);
		}
		return dtos;
	}
	public List<UserDto> getAllUsersJava8() {

		return repository.findAll().stream()
					.map(user -> {
						UserDto dto = new UserDto();
						dto.setUserName(user.getUserName());
						dto.setFullName(String.format("%s %s", user.getFirstName(), user.getLastName()));
						dto.setActive(user.getDeactivationDate() == null);
						return dto;
					})
					.collect(toList());
	}

	public List<UserDto> getAllUsersJava8Better() {
		return repository.findAll().stream()
					.map(this::toDto)
					.collect(toList());
	}

	private UserDto toDto(User user) {
		UserDto dto = new UserDto();
		dto.setUserName(user.getUserName());
		dto.setFullName(String.format("%s %s", user.getFirstName(), user.getLastName()));
		dto.setActive(user.getDeactivationDate() == null);
		return dto;
	}

}
