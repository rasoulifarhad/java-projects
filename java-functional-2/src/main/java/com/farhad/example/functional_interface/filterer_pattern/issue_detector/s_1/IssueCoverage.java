package com.farhad.example.functional_interface.filterer_pattern.issue_detector.s_1;

import java.util.stream.Collector;

public class IssueCoverage {

	// static Collector<IssueWiseText<?>, ?, Double> collector(Predicate<? super Issue> issueFilter) {
	// 	return Collector.of(
	// 		() -> new Accumulator(issueFilter), 
	// 		Accumulator::accumulate, 
	// 		Accumulator::combine,
	// 		Accumulator::finish,
	// 		Collector.Characteristics.UNORDERED);
	// }

	static Collector<IssueWiseText<?>, ?, Double> collector() {
		return Collector.of(
			Accumulator::new, 
			Accumulator::accumulate, 
			Accumulator::combine,
			Accumulator::finish,
			Collector.Characteristics.UNORDERED);
	}
	
	private static class Accumulator {
		
		// private final Predicate<? super Issue> issueFilter;
		int totalIssueLength = 0;
		int totalTextLength = 0;

		
		// public Accumulator(Predicate<? super Issue> issueFilter) {
		// 	this.issueFilter = issueFilter;
		// }

		// void accumulate(IssueWiseText<?> issueWiseText) {
		// 	totalIssueLength += issueWiseText.issues().stream().filter(issueFilter).mapToInt(Issue::length).sum();
		// 	totalTextLength += issueWiseText.text().length();
		// }

		void accumulate(IssueWiseText<?> issueWiseText) {
			totalIssueLength += issueWiseText.issues().stream().mapToInt(Issue::length).sum();
			totalTextLength += issueWiseText.text().length();
		}

		Accumulator combine(Accumulator other) {
			totalIssueLength += other.totalIssueLength;
			totalTextLength += other.totalTextLength;
			return this;
		}

		double finish() {
			return (double) totalIssueLength / totalTextLength;
		}
		
	}
}

