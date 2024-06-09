package com.farhad.example.java_tips.count_demo.result;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import com.farhad.example.java_tips.count_demo.split.SplitToWords;

public class WordCountResult {

    private BiFunction<Map<String, Integer>, String,Map<String, Integer>> acc = (map, word) ->  {
        String key = word.toLowerCase();
        var count = map.get(key);
        map.put(key, count == null ? 0 : count +1);
        return map;
    };

    private BinaryOperator<Map<String, Integer>> combiner = (a, b) -> {
        a.putAll(b);
        return a;
    };

    public List<String> count(Path file, int limit) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
          Stream<String> words = new SplitToWords().split(lines);
          Map<String, Integer> m = words.reduce(new HashMap<>(), acc, combiner);
          return m.entrySet().stream()
            .filter(e -> e.getValue() > limit && e.getKey().length() > 4  && !e.getKey().startsWith("["))
            .map(Map.Entry::getKey)
            .sorted(String::compareToIgnoreCase)
            .collect(toList());
        } 
    }
}
