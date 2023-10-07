package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import java.util.UUID;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Role.RoleId;
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
public class Role implements AggregateRoot<RoleId> {
	
	@EqualsAndHashCode.Include
	private RoleId id;
	private String name;


	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Value
	public static class RoleId {
		private final String uuid;

		public static RoleId newId() {
			return new RoleId(UUID.randomUUID().toString());
		}

		public static RoleId from(String uuid) {
			return new RoleId(UUID.fromString(uuid).toString());
		}
	}

}
