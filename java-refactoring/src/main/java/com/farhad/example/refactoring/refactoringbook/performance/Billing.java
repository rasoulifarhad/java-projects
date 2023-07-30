package com.farhad.example.refactoring.refactoringbook.performance;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Billing {
	

	public String statement(Invoice invoice, Map<PlayID, Play> plays ) {

		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMinimumFractionDigits(2);
		format.setCurrency(Currency.getInstance("USD"));
		
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
										.append(play.getName())
										.append(": ")
										.append(format.format( amount / 100) )
										.append(" ")
										.append("(")	
										.append(performance.getAudience())
										.append(" seats")
										.append(")\n");
			totalAmount += amount;
		}
		stringBuilder = stringBuilder.append("Amount owed is ")
									.append(format.format(totalAmount / 100))
									.append("\n");
		stringBuilder.append("You earned ")
					.append(volumeCredits)
					.append(" credits\n");
		return stringBuilder.toString();
	}

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		URL invoicesUrl = Billing.class.getResource("invoices.json");
		URL playsUrl = Billing.class.getResource("plays.json");
		ObjectMapper mapper = new ObjectMapper();

		List<Invoice> invoices = mapper.readValue(new File(invoicesUrl.getFile()), new TypeReference<List<Invoice>>() {});
		// List<Invoice> invoices = mapper.readValue(new File(invoicesUrl.getFile()), mapper.getTypeFactory().constructCollectionType(List.class, Invoice.class));
		Map<PlayID, Play> plays = mapper.readValue(new File(playsUrl.getFile()), new TypeReference<Map<PlayID, Play>>() {});
		// Map<PlayID, Play> plays = mapper.readValue(new File(playsUrl.getFile()), mapper.getTypeFactory().constructMapLikeType(HashMap.class, PlayID.class, Play.class));
		
		Billing billing = new Billing();
		for (Invoice invoice : invoices) {
			System.out.println( billing.statement(invoice, plays));
		}
		
	}
}
