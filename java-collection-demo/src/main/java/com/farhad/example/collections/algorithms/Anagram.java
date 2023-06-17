package com.farhad.example.collections.algorithms;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Anagram {
    
    public static Map<String, List<String>> anagrams(int minGroupSize) {
        URL url =  Anagram.class.getResource("dictionary.txt");
        return anagrams( 
                    new File(url.getFile()),
                    minGroupSize);
    }

    public static Map<String, List<String>> anagrams(File file, int minGroupSize) {
        Map<String, List<String>> m = anagrams(file);
        return m.entrySet()
                    .stream()
                    .filter(e -> e.getValue().size() >= minGroupSize)
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }
    
    public static List<List<String>> anagramsList(int minGroupSize) {
        URL url =  Anagram.class.getResource("dictionary.txt");
        return anagramsList( 
                    new File(url.getFile()),
                    minGroupSize);
    }

    public static List<List<String>> anagramsList(File file, int minGroupSize) {
        Map<String, List<String>> m = anagrams(file);
        return m.entrySet()
                    .stream()
                    .filter(e -> e.getValue().size() >= minGroupSize)
                    .map(Entry::getValue)
                    .collect(Collectors.toList());
    }

    public static Map<String, List<String>> anagrams(File file) {
        Map<String, List<String>> m = new HashMap<>();
        try {
            Scanner s = new Scanner(file);
            while(s.hasNext()) {
                String word = s.next();
                String alpha = alphabetize(word);
                List<String> l = m.get(alpha);
                if( l == null) {
                    m.put( alpha , l = new ArrayList<>());
                }
                l.add(word);
            }  
            s.close();          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    private static String alphabetize(String word) {
        char [] c = word.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static void main(String[] args) {
        URL url =  Anagram.class.getResource("dictionary.txt");
        Map<String, List<String>> map = anagrams( 
                                            new File( 
                                                url.getFile()));
        map.entrySet()
                .forEach(entry -> log.info("Key: {}, values: {}",entry.getKey(), entry.getValue()));
    }
}
