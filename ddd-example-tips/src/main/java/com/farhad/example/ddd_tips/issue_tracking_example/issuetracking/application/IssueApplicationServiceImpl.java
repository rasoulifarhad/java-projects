package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application;

import static com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.CurrentUser.USER_1;
import static com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.issue.Issue.IssueId.from;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.CreateCommentDTO;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.IssueApplicationService;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.issue.IssueAssignDTO;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.issue.IssueCreationDTO;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.issue.IssueDTO;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.issue.IssueMapper;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.GitRepository;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.issue.Issue;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.issue.IssueManager;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.issue.IssueRepository;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.user.User;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.user.UserRepository;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.BusinessException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IssueApplicationServiceImpl implements IssueApplicationService {

	private final IssueRepository issueRerpository;
	private final UserRepository userRepository;
	private final IssueManager issueManager; 
	private final IssueMapper mapper;

	@Override
	public void createComment(CreateCommentDTO input) {
		issueRerpository.findById(from(input.getIssueId()))
				.ifPresent(issue -> {
					issue.addComment(USER_1.getUserId(), input.getText());
					issueRerpository.save(issue);
				});
	}


	@Override
	public void assign(IssueAssignDTO input) {
		User user = userRepository.findById(input.getUserId())
						.orElseThrow(() -> new BusinessException("IssueTracking.userNotFound"));
		Issue issue = issueRerpository.findById(input.getIssueId())
						.orElseThrow(() -> new BusinessException("IssueTracking.issueNotFound"));
		issueManager.assignTo(issue, user);
		issueRerpository.save(issue);
	}


	@Override
	public IssueDTO create(IssueCreationDTO input) {
		Issue issue = 
			issueManager.create(
					GitRepository.Id.from(input.getGitRepositoryId()), 
					input.getTitle(), 
					input.getText());
		if(input.getAssignedUserId() != null) {
			User user = userRepository.findById(User.UserId.from(input.getAssignedUserId()))
							.orElseThrow(() -> new BusinessException("IssueTracking.assignedUserNotFound"));
			issueManager.assignTo(issue, user);
		}
		issueRerpository.save(issue);
		return mapper.toIssueDTO(issue);
	}


	@Override
	public IssueDTO update(String issueId, IssueCreationDTO input) {

		Issue issue = issueRerpository.findById(Issue.IssueId.from(issueId))
			.orElseThrow(() -> new BusinessException("IssueTracking.issueNotFound"));
		
		issueManager.changeTitle(issue, input.getTitle());
		if(input.getAssignedUserId() != null) {
			User user = userRepository.findById(User.UserId.from(input.getAssignedUserId()))
							.orElseThrow(() -> new BusinessException("IssueTracking.assognedUserNotFound"));
			issueManager.assignTo(issue, user);
		}

		issue.setText(input.getText());
		issueRerpository.save(issue);

		return mapper.toIssueDTO(issue);
	}

	
	
}
