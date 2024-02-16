package com.farhad.example.design_principles02.implicit_dependencies.explicit_dependencies;

import java.io.IOException;
import java.time.LocalTime;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonalizedResponse {

	private final Logger logger;
	private final LocalTime time;

	public String getResponse(Customer customer) throws IOException {
		logger.log("Generating personalized response.");
		String format = "Good %s, %s %s! would you like a %s widget today";
		String timeOfDay = "afternoon";
		if (time.getHour() < 12) {
			timeOfDay = "morning"; 
		} else if(time.getHour() > 17) {
			timeOfDay = "evening";
		}

		return String.format(format,
				timeOfDay,
				customer.getTitle(),
				customer.getFullName(),
				customer.getFavoriteColor());
	}

}
