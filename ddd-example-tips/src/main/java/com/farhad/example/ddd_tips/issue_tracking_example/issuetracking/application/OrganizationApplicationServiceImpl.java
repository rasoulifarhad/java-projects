package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.AuthorizationService;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.EmailSender;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.OrganizationApplicationService;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.OrganizationDTO;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.OrganizationMapper;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.PaymentService;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.organization.Organization;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.organization.OrganizationManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrganizationApplicationServiceImpl implements OrganizationApplicationService {

	private final OrganizationManager organizationManager;
	private final EmailSender emailSender;
	private final PaymentService paymentService;
	private final OrganizationMapper mapper;
	private final AuthorizationService authorizationService;
	private final CurrentUser currentUser;


	@Override
	public OrganizationDTO create(String name) {

		authorizationService.ckeck("OrganizationCreationPermission");
		paymentService.charge(currentUser.getUserId(), getOrganizationPrice());
		Organization organization = organizationManager.create(name);
		log.debug("Creating organization {} by {}", name, currentUser.getUserId());
		emailSender.send(
			"xxxx@example.com",
			"New organization",
			"a new organization created with: " + name);
		return mapper.toIssueDTO(organization);
	}


	private double getOrganizationPrice() {
		return 42.00;
	}
	

}
