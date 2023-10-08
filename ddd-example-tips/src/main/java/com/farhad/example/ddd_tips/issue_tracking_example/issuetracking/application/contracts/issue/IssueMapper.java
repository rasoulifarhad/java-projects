package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.application.contracts.issue;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.model.issue.Issue;

@Mapper
public interface IssueMapper {
	IssueMapper INSTANCE = Mappers.getMapper( IssueMapper.class );

	@Mapping(source = "id.uuid", target = "issueId")
	@Mapping(source = "title", target = "title")
	@Mapping(source = "text", target = "text")
	@Mapping(source = "gitRepositoryId.uuid", target = "gitRepositoryId")
	@Mapping(source = "assignedUserId.uuid", target = "assignedUserId")
	IssueDTO toIssueDTO(Issue issue);
}
