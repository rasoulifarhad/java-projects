package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

public interface IssueDetector {
	ProbabilisticIssueWiseText detect(String text, double probabilityThreshold);
}