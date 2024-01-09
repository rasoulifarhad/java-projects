package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

import java.util.stream.Stream;

public class Usage {

	static double IssueCoverage(Stream<? extends IssueWiseText<?>> textStream) {
		return textStream.collect(IssueCoverage.collector());
	}
	static Stream<IssueWiseText<Issue>> testCAseStream() {
		return Stream.of();
	}
}
