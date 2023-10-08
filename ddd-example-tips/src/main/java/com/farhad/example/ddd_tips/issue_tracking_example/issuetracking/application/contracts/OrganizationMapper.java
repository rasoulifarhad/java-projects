package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.organization.Organization;

@Mapper
public interface OrganizationMapper {
	
	OrganizationMapper INSTANCE = Mappers.getMapper( OrganizationMapper.class );

	@Mapping(source = "id.uuid", target = "organizationId")
	@Mapping(source = "name", target = "name")
	OrganizationDTO toIssueDTO(Organization organization);	
}
