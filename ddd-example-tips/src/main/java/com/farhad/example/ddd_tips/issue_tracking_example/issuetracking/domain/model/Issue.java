package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model;

import static java.util.Objects.requireNonNull;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.GitRepository.Id;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.Issue.IssueId;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.User.UserId;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.service.UserIssueService;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.AggregateRoot;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.BusinessException;

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

	@Setter(value = AccessLevel.PUBLIC)
	private String text;

	private boolean isClosed;

	private boolean isLocked;

	private IssueCloseReason closeReason;

	private GitRepository.Id gitRepositoryId;

	private UserId assignedUserId;

	private List<Comment> comments;

	private List<IssueLable>  issueLables;

	private Instant creationTime;

	private Instant lastCommentTime;

	private MilestoneId milestoneId;

	public Issue(IssueId id, String title, String text, Id gitRepositoryId, UserId assignedUserId) {
		this.id = id;
		this.title = requireNonNull(title);
		this.text = text;
		this.gitRepositoryId = requireNonNull(gitRepositoryId);
		this.assignedUserId = assignedUserId;
		this.issueLables = new ArrayList<>();
		this.comments = new ArrayList<>();
		this.isClosed = false;
		this.isLocked = false;
		this.creationTime = Instant.now();
	}

	public void addComment(UserId userId, String text) {
		comments.add(
				new Comment(
						Comment.CommentId.newId(), 
						text, 
						id, 
						userId));
	}

	public void assignTo(User user, UserIssueService userIssueService) {
		int openIssueCount = userIssueService.getOpenIssuesCountFor(user.getId());
		if(openIssueCount >= 3) {
			throw new BusinessException("IssueTracking:ConcurrentOpenIssueLimit");
		}
		assignedUserId = user.getId();
	}

	public void cleanAssignment() {
		assignedUserId = null;
	}

	public void setTitle(String title) {
		this.title = requireNonNull(title);
	}
	public void close(IssueCloseReason closeReason) {
		isClosed = true;
		this.closeReason = closeReason;
	}

	public void reOpen() {
		if (isLocked()) {
			// Can not open a locked issue! Unlock it first
			throw new IssueStateException("IssueTracking:CanNotOpenLockedIssue"); 
		}
		isClosed = false;
		this.closeReason = null;
	}

	public void lock() {
		if(!isClosed()) {
			// Can not lock opened issue! close it first
			throw new IssueStateException("IssueTracking:CanNotLockOpenedIssue"); 
		}
		isLocked = true;
	}

	public void unlock() {
		this.isLocked = false;
	}

	// business rule that defines an in-active issue: 
	// - The issue should be open, 
	// - assigned to nobody, 
	// - created 30+ days ago and 
	// - has no comment in the last 30 days.
	public boolean isInactive() {
		return new InactiveIssueSpecification().isSatisfiedBy(this);
		// Instant daysAgo30 = Instant.now()
		// 						.truncatedTo(ChronoUnit.DAYS)
		// 						.minus(30, ChronoUnit.DAYS);
		// return 
		// 	!isClosed && 
		// 	assignedUserId == null && 
		// 	creationTime.isBefore(daysAgo30) &&
		// 	(lastCommentTime == null || lastCommentTime.isBefore(daysAgo30));
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
