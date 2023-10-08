package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.AggregateRoot;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements AggregateRoot<User.UserId> {

	@EqualsAndHashCode.Include
	private UserId id;
	private String username;
	private String password;

	private List<UserRole> roles = new ArrayList<>();

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
