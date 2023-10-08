package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class OrganizationDTO {
	private String organizationId;
	private String name;
}
