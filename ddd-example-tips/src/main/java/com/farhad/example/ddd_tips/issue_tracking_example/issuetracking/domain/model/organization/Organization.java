package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.organization;

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
@AllArgsConstructor
public class Organization implements AggregateRoot<Organization.OrganizationId> {

	@EqualsAndHashCode.Include
	private OrganizationId id;
	private String name;


	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Value
	public static class OrganizationId {
		private final String uuid;

		public static OrganizationId newId() {
			return new OrganizationId(UUID.randomUUID().toString());
		}

		public static OrganizationId from(String uuid) {
			return new OrganizationId(UUID.fromString(uuid).toString());
		}
	}

}
