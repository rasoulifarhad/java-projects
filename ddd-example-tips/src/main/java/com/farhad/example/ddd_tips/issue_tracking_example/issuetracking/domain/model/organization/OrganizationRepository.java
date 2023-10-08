package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.organization;

import com.farhad.example.ddd_tips.specifications.Specification;

public interface OrganizationRepository {
	boolean any(Specification<Organization> specification );

	void save(Organization organization); 
	
}
