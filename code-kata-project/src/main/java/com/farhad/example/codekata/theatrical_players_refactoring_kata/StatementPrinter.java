package com.farhad.example.codekata.theatrical_players_refactoring_kata;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays) {

        int totalAmount = 0;
        int volumeCredits = 0;
        String result = String.format("Statement for %s $n", invoice.getCustomer());

        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance performance : invoice.getPerformances()) {
            Play play = plays.get(performance.getPlayId());
            int thisAmount = 0;

            switch (play.getType()) {
                case "tragedy":
                    thisAmount = 40000;
                    if(performance.getAudience() > 30) {
                        thisAmount += 1000 * (performance.getAudience() - 30);
                    }
                    break;
                case "comedy": 
                    thisAmount = 30000;
                    if(performance.getAudience() > 20) {
                        thisAmount += 10000 + 500 * (performance.getAudience() - 20);
                    }
                    thisAmount += 300 * performance.getAudience();
                    break;
                default:
                    throw new Error("unknown type:" + play.getType());
            }

            // add volume credits
            volumeCredits += Math.max(performance.getAudience(), 0);
            // add extra credit for every ten comedy attendees
            if("comedy".equals(play.getType())) volumeCredits += Math.floor(performance.getAudience() / 5);

            // print line for this order
            result += String.format("  %s: %s (%s seats)\n",play.getName(), frmt.format(thisAmount / 100), performance.getAudience());
            totalAmount += thisAmount;
        }
        result += String.format("Amount owed is %s\n", frmt.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }
}
