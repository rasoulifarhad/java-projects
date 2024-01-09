package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

import java.util.stream.Stream;

public class Usage {

	// static double IssueCoverage(Stream<? extends IssueWiseText<?>> textStream) {
	// 	return textStream.collect(IssueCoverage.collector(issue -> true));
	// }

	static double IssueCoverage(Stream<? extends IssueWiseText> textStream) {
		return textStream.collect(IssueCoverage.collector());
	}
	// static double IssueCoverage(Stream<? extends IssueWiseText<?>> textStream, IssueType issueType) {
	// 	return textStream.collect(IssueCoverage.collector(issue -> issue.type() == issueType));
	// }


	static double IssueCoverage(Stream<? extends IssueWiseText> textStream, IssueType issueType) {
		return textStream
					.map(issueWiseText -> issueWiseText.filtered(issue -> issue.type() == issueType) )
					.collect(IssueCoverage.collector());

	}

	static Stream<IssueWiseText> testCAseStream() {
		return Stream.of();
	}
}
