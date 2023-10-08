package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.organization;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.BusinessException;
import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared.DomainService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrganizationManager implements DomainService {
	
	private final OrganizationRepository organizationRepository;

	public Organization create(String name) {
		if(organizationRepository.any(o -> o.getName().equals(name))) {
			throw new BusinessException("IssueTracker.DuplicateOrganizationName");
		}

		Organization organization = new Organization(
			Organization.OrganizationId.newId(), name);
		organizationRepository.save(organization);
		return organization;
	}
}
