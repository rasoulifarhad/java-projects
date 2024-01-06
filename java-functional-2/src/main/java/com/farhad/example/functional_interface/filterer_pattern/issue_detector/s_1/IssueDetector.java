package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

import java.util.List;

public interface IssueDetector {
	List<Issue> detect(String text);

	List<Issue> detect(String text, double probabilityThreshold);
}