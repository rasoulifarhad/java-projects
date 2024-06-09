package com.farhad.example.java_tips;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class StatisticsDemo {

    public static void main(String[] args) {
        new StatisticsDemo().demo();
    }

    private void demo() {
        List<Kid> kids = Arrays.asList(
            new Kid("kid #1", 8),
            new Kid("kid #2", 8),
            new Kid("kid #3", 7),
            new Kid("kid #4", 7),
            new Kid("kid #5", 8),
            new Kid("kid #6", 6)
        );

        int min = kids.stream()
            .mapToInt(Kid::getAge)
            .min()
            .orElseThrow(NoSuchElementException::new);
        int max = kids.stream()
            .mapToInt(Kid::getAge)
            .max()
            .orElseThrow(NoSuchElementException::new);
        
        System.out.println(
            String.format("Using our own implementation: Youngest: %d Eldest: %d",
                 min, max));

        IntSummaryStatistics statistics = kids.stream()
            .mapToInt(Kid::getAge)
            .summaryStatistics();
        System.out.println(
                String.format("Using IntSummaryStatistics: Youngest: %d Eldest: %d",
                     statistics.getMin(), statistics.getMax()));
        System.out.println(
                        String.format("Other statistics: Average age: %.2f Number of classmates: %d Sum of ages: %d",
                             statistics.getAverage(), statistics.getCount(), statistics.getSum()));
                
    }

    @RequiredArgsConstructor
    @Getter
    static class  Kid {
    
            private final String name;
            private final int age;
        
    }
}
