package com.farhad.example.design_principles02.implicit_dependencies;

import java.io.IOException;
import java.time.LocalTime;

public class PersonalizedResponse {

	public String getResponse() throws IOException {
		Context.log("Generating personalized response.");
		String format = "Good %s, %s %s! would you like a %s widget today";
		String timeOfDay = "afternoon";
		if (LocalTime.now().getHour() < 12) {
			timeOfDay = "morning"; 
		} else if(LocalTime.now().getHour() > 17) {
			timeOfDay = "evening";
		}

		return String.format(format,
				timeOfDay,
				Context.getCurrentCustomer().getTitle(),
				Context.getCurrentCustomer().getFullName(),
				Context.getCurrentCustomer().getFavoriteColor());
	}

}
