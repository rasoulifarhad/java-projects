package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

import java.util.List;
import java.util.function.Predicate;

public interface IssueWiseText<I extends Issue> {

	String text();

	List<I> issues();

	IssueWiseText<I> filtered(Predicate<? super I> issueFilter);
}
