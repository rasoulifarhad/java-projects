package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Issue.IssueId;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.User.UserId;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.Entity;

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
public class Comment implements Entity{

	@EqualsAndHashCode.Include
	private CommentId commentId;
	private String text;
	private IssueId issueId;
	private UserId userId;

	

	public Comment(CommentId commentId, String text, IssueId issueId, UserId userId) {
		this.commentId = commentId;
		this.text = requireNonNull(text);
		this.issueId = requireNonNull(issueId);
		this.userId = requireNonNull(userId);
	}



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
