package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

import java.util.List;
import java.util.function.Predicate;

public interface IssueWiseText {

	String text();

	List<? extends Issue> issues();

	IssueWiseText filtered(Predicate<? super Issue> issueFilter);
}
