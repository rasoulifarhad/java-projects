package com.farhad.example.refactoring.refactoringbook.performance;

import java.util.Map;

public class Billing {
	

	public String statement(Invoice invoice, Map<String, Play> plays ) {

		double totalAmount =  0.0;
		double volumeCredits = 0.0;
		StringBuilder stringBuilder = new StringBuilder("Statement for " + invoice.getCustomer() + "\n");
		for (Performance performance : invoice.getPerformances()) {
			final Play play = plays.get(performance.getPlayID()); 
			double amount = 0;
			switch (play.getType()) {
				case "comedy":
					amount = 30000;
					if (performance.getAudience() > 20 ) {
						amount += 10000 + 500 * (performance.getAudience() - 20 );
					}
					amount += 300 * performance.getAudience();
					break;
				case "tragedy": 
					amount = 40000;
					if (performance.getAudience() > 30 ) {
						amount += 1000 * (performance.getAudience() - 30 );
					}
					break;
				default:
					throw new Error("unknown typ: " + play.getType());
			} 
			// add volume credits
			volumeCredits += Math.max(performance.getAudience() - 30 , 0);
			// add extra credit for every ten comedy attendees
			if ("comedy".equals(play.getType())) {
				volumeCredits += Math.floor(performance.getAudience() / 5);
			}

			// print line for this order
			stringBuilder = stringBuilder.append("  ")
										.append(play.getType())
										.append(": ")
										.append(amount / 100 )
										.append(" ")
										.append(performance.getAudience())
										.append(" seats.\n");
			totalAmount += amount;
		}
		stringBuilder = stringBuilder.append("Amount owed is ")
									.append(totalAmount / 100)
									.append("\n");
		stringBuilder.append("You earned ")
					.append(volumeCredits)
					.append(" credits.\n");
		return stringBuilder.toString();
	}
}
