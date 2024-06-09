package com.farhad.example.java_tips;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class JavaStreamAndFilesFind {

    public static void main(String[] args) {
        new JavaStreamAndFilesFind().demo();
    }

    private void demo() {
        demoStreams();
        demoFilesFind();
    }

    private void demoFilesFind() {
        var currentDir = Path.of(System.getProperty("user.dir"));
        try {
            Files.find(currentDir, 6, new BiPredicate<Path,BasicFileAttributes>() {

                @Override
                public boolean test(Path path, BasicFileAttributes basicFileAttributes) {
                    return path.toString().contains("$");
                }
                
            }).map(Path::getFileName).forEach(System.out::println);;
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void demoStreams() {
        var words = Stream.of("a", "an", "before", "being", "cannot", "death", "do", "first", "great"))
        words.filter(w -> w.length() > 4).forEach(System.out::println);

        Stream<Integer> ints = Stream.generate(new Supplier<Integer>() {
            Integer state = 1;

            @Override
            public Integer get() {
                Integer value = state;
                state += 1;
                return value;
            }
        });

        ints.limit(10).forEach(System.out::println);
    }
}
