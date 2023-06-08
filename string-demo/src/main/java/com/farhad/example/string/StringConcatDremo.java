package com.farhad.example.string;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import net.datafaker.Faker;

public class StringConcatDremo {
    
    private static final int COUNT = 200_000;
    private List<String> colors ;

    public StringConcatDremo() {
        Faker faker = new Faker();
        colors = IntStream.range(1, COUNT)
                            .mapToObj(operand ->  faker.color().name())
                            .collect(Collectors.toList());
    }

    String getAllColors() {
        String retVal = "";
        for (String color : colors) {
           retVal += color + "\n";
        }
        return retVal;
    }

    String getAllColorsWithStringBuilder() {
        StringBuffer sb = new StringBuffer();

        for (String color : colors) {
           sb.append(color);
           sb.append("\n");
        }
        return sb.toString();
    }

}
