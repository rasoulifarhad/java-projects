package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

import java.util.List;

public interface IssueWiseText {

	String text();

	List<? extends Issue> issues();

	Filterer<? extends IssueWiseText, ? extends Issue> filtered();
}
