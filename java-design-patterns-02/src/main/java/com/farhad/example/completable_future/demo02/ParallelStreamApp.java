package com.farhad.example.completable_future.demo02;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamApp {
    public static void main(String[] args) {
        
        CategorizationService service = new CategorizationService();
        long start = System.currentTimeMillis();
        List<Category> categories = Stream.of(
                new Transaction("1", "description 1"),
                new Transaction("2", "description 2"),
                new Transaction("3", "description 3"),
                new Transaction("4", "description 4"),
                new Transaction("5", "description 5"),
                new Transaction("6", "description 6"),
                new Transaction("7", "description 7"),
                new Transaction("8", "description 8"),
                new Transaction("9", "description 9"),
                new Transaction("10", "description 10"))
            .parallel()
            .map(service::categirizeTransaction)
            .collect(toList());
        long end = System.currentTimeMillis();
        System.out.printf("The operatin took %s ms%n", end - start);
        System.out.println("Categories are:" + categories);
    }
}
