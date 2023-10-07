package com.farhad.example.ddd_tips.issue_tracking_example.issuetracking.domain.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BusinessException extends RuntimeException {

	@NotNull
	@NotBlank
	private String code;

}
