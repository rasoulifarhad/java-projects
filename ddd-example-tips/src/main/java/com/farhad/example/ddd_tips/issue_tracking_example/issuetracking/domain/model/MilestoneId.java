package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class MilestoneId {
	
		private final String uuid;

		public static MilestoneId newId() {
			return new MilestoneId(UUID.randomUUID().toString());
		}

		public static MilestoneId from(String uuid) {
			return new MilestoneId(UUID.fromString(uuid).toString());
		}

}
