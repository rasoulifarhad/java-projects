package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

import java.util.List;

public interface IssueWiseText<I extends Issue> {

	String text();

	List<I> issues();
}
