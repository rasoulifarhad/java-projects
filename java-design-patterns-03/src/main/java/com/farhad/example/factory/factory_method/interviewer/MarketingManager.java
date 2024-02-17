package com.farhad.example.factory.factory_method.interviewer;

public class MarketingManager extends HiringManager {

	@Override
	protected Interviewer makeInterviewer() {
		return new CommunityExecutive();
	}

}
