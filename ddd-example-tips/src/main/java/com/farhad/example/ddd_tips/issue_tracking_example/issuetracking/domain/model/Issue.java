package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.GitRepository.Id;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Issue.IssueId;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.User.UserId;
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
public class Issue implements AggregateRoot<IssueId>{

	@EqualsAndHashCode.Include
	private IssueId id;
	private String title;
	private String text;
	private boolean isClosed;
	private IssueCloseReason closeReason;

	private GitRepository.Id gitRepositoryId;
	private UserId assignedUserId;

	private List<Comment> comments;
	private List<IssueLable>  issueLables;



	public Issue(IssueId id, String title, String text, Id gitRepositoryId, UserId assignedUserId) {
		this.id = id;
		this.title = requireNonNull(title);
		this.text = requireNonNull(text);
		this.gitRepositoryId = requireNonNull(gitRepositoryId);
		this.assignedUserId = requireNonNull(assignedUserId);
		this.issueLables = new ArrayList<>();
		this.comments = new ArrayList<>();
	}

	public void addComment(UserId userId, String text) {
		comments.add(
				new Comment(
						Comment.CommentId.newId(), 
						text, 
						id, 
						userId));
	}

	public void setTitle(String title) {
		this.title = requireNonNull(title);
	}
	public void close(IssueCloseReason closeReason) {
		isClosed = true;
		this.closeReason = closeReason;
	}

	public void reOpen() {
		isClosed = false;
		this.closeReason = null;
	}

	public enum IssueCloseReason {

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
	
	
}
