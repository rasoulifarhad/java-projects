package com.farhad.example.scanner;

import java.util.Map;

public class Interviewer {
    String askColorQuestion() {
        // return "Enter your favorite color:";
        return Messages.getString("Interviewer.color.question");
    }

    String respondToColorAnswer(String color) {
        Map<String,String> colorMap =  Messages.getStrings("Interviewer.color.definition.");
        for (String colorKey : colorMap.keySet()) {
            String colorValue = colorMap.get(colorKey);
            if (colorValue.equalsIgnoreCase(color)) {
                String responseKey = colorKey.replace("definition", "response");
                return Messages.getString(responseKey);
            }
        }
        return Messages.getString("Interviewer.color.response.default");
        // switch (color) {
        //     case "red":
        //         // return "Roses are red";
        //         return Messages.getString("Interviewer.color.response.1");
        //     case "blue":
        //         // return "Violets are blue";
        //         return Messages.getString("Interviewer.color.response.2");
        //     case "yellow":
        //         // return "Java is awesome";
        //         return Messages.getString("Interviewer.color.response.3");
        //     default:
        //         // return "And so are you";
        //         return Messages.getString("Interviewer.color.response.default");
        // }
    }

    String anotherBadRespondToColorAnswer(String color) {
        Map<String,String> colorMap =  Messages.getStrings("Interviewer.color.definition.");
        for (String colorKey : colorMap.keySet()) {
            String colorValue = colorMap.get(colorKey);
            if (colorValue.equalsIgnoreCase(color)) {

                String part1 = Messages.getString("Interviewer.color.response.part1");
                String part2 = Messages.getString("Interviewer.color.response.part2");
                return String.format("%s %s %s", part1, color, part2);
            }
        }
        return Messages.getString("Interviewer.color.response.default");
    }

    String anotherGoodRespondToColorAnswer(String color) {
        Map<String,String> colorMap =  Messages.getStrings("Interviewer.color.definition.");
        for (String colorKey : colorMap.keySet()) {
            String colorValue = colorMap.get(colorKey);
            if (colorValue.equalsIgnoreCase(color)) {

                String format = Messages.getString("Interviewer.color.response");
                return String.format(format, color);
            }
        }
        return Messages.getString("Interviewer.color.response.default");
    }

}
