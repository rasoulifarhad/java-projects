package com.farhad.example.factory.factory_method.interviewer;

public class DevelopmentManager extends HiringManager {

	@Override
	protected Interviewer makeInterviewer() {
		return new Developer();
	}

}
