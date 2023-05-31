package com.farhad.example.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListToStringDemo {

    private static final String DEFAULT_SEPERATOR = ",";
    public static void main(String[] args) {
        
        List<String> countries = Arrays.asList(
                "USA",
                "Iran",
                "Germany",
                "Italy",
                "Uk"   
        );

        String commaSeperatedCountries = String.join(DEFAULT_SEPERATOR, countries);
        log.info("{}", commaSeperatedCountries);

        commaSeperatedCountries = countries.stream()
                                            .collect(Collectors.joining(DEFAULT_SEPERATOR));
        log.info("{}", commaSeperatedCountries);
        
        commaSeperatedCountries = countries.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.joining(DEFAULT_SEPERATOR));
        log.info("{}", commaSeperatedCountries);
    }
}
