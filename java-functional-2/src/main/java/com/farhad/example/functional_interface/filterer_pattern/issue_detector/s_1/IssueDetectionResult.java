package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

import java.time.Duration;

public interface IssueDetectionResult {
	IssueWiseText<ProbableIssue> probabilisticIssueWiseText();

	Duration detectionTime();
}
