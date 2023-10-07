package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import java.util.UUID;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.AggregateRoot;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GitRepository implements AggregateRoot<GitRepository.Id>{

	@EqualsAndHashCode.Include
	private GitRepository.Id id;
	private String name;
	private int starCount;

	@RequiredArgsConstructor
	@Value
	public static class Id {
		private final String uuid;

		public static Id newId() {
			return new Id(UUID.randomUUID().toString());
		}

		public static Id from(String uuid) {
			return new Id(UUID.fromString(uuid).toString());
		}

	}
}
