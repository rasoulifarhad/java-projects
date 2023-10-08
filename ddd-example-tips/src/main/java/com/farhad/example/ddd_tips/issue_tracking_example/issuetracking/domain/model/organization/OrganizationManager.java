package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.organization;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.CurrentUser;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.service.AuthorizationService;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.service.EmailSender;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.BusinessException;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.DomainService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrganizationManager implements DomainService {
	
	private final OrganizationRepository organizationRepository;
	private final AuthorizationService authorizationService;
	private final EmailSender emailSender;
	private final CurrentUser currentUser;

	public Organization create(String name) {
		if(organizationRepository.any(o -> o.getName().equals(name))) {
			throw new BusinessException("IssueTracker.DuplicateOrganizationName");
		}

		authorizationService.ckeck("OrganizationCreationPermission");
		log.debug("Creating organization {} by {}", name, currentUser.getUserId());
		Organization organization = new Organization(
			Organization.OrganizationId.newId(), name);
		emailSender.send(
			"xxxx@example.com",
			"New organization",
			"a new organization created with: " + name);
		return organization;
	}
}
