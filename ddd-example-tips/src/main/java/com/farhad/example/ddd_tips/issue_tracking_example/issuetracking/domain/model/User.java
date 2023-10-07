package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import java.util.UUID;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.AggregateRoot;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

public class User implements AggregateRoot {
	
	private UserId id;
	private String username;
	private String password;


	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Value
	public static class UserId {
		private final String uuid;

		public static UserId newId() {
			return new UserId(UUID.randomUUID().toString());
		}

		public static UserId from(String uuid) {
			return new UserId(UUID.fromString(uuid).toString());
		}
	}


}
