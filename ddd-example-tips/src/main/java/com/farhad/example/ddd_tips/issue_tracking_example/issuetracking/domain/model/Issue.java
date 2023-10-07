package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.User.UserId;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.AggregateRoot;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
public class Issue implements AggregateRoot{

	public enum CloseReason {

	}

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Value
	public static class IssueId {
		private final String uuid;

		public static IssueId newId() {
			return new IssueId(UUID.randomUUID().toString());
		}

		public static IssueId from(String uuid) {
			return new IssueId(UUID.fromString(uuid).toString());
		}
	}

	private IssueId id;
	private String text;
	private boolean isClosed;
	private CloseReason closeReason;

	private GitRepository.Id gitRepositoryId;
	private UserId assignedUserId;

	private List<Comment> comments = new ArrayList<>();
	private List<IssueLable>  issueLables = new ArrayList<>();


	public void addComment(UserId userId, String text) {
		comments.add(
				new Comment(
						Comment.CommentId.newId(), 
						text, 
						id, 
						userId));

	}

	
	
}
