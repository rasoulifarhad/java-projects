package com.farhad.example.factory.factory_method.interviewer;

public abstract class HiringManager {

	abstract protected Interviewer makeInterviewer();

	public void takeInterview() {
		Interviewer interviewer = makeInterviewer();
		System.out.println(interviewer.askQuestions());
	}
}
