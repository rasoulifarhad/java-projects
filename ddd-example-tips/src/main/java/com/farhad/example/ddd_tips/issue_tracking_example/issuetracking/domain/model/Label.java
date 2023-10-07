package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import java.util.UUID;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.AggregateRoot;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

public class Label implements AggregateRoot{
	
	private LableId id;
	private String name;
	private String color;

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Value
	public static class LableId {
		private final String uuid;

		public static LableId newId() {
			return new LableId(UUID.randomUUID().toString());
		}

		public static LableId from(String uuid) {
			return new LableId(UUID.fromString(uuid).toString());
		}
	}


}
