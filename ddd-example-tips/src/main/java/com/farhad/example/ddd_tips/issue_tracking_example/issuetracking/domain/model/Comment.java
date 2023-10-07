package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import java.util.UUID;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Issue.IssueId;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.User.UserId;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@AllArgsConstructor
@Data
public class Comment implements Entity{
	
	private CommentId commentId;
	private String text;
	private IssueId issueId;
	private UserId userId;

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Value
	public static class CommentId {
		private final String uuid;

		public static CommentId newId() {
			return new CommentId(UUID.randomUUID().toString());
		}


		public static CommentId from(String uuid) {
			return new CommentId(UUID.fromString(uuid).toString());
		}
	}


}
