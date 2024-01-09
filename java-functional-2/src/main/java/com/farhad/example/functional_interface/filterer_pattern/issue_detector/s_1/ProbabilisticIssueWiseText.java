package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

import java.time.Duration;
import java.util.List;

public interface ProbabilisticIssueWiseText extends IssueWiseText {

	@Override
	List<? extends ProbableIssue> issues();

	Duration detectionTime();

	@Override
	Filterer<? extends ProbabilisticIssueWiseText, ? extends ProbableIssue> filtered();


}
