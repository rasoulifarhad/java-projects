package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import java.util.UUID;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.AggregateRoot;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Data
public class GitRepository implements AggregateRoot{
	
	private GitRepository.Id id;
	private String name;

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
