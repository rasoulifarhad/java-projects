package com.farhad.example.collections.set;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SetDemo {
    
    private static final String TEXT = "i came i saw i left";
    private Collection<String> words = Arrays.asList(TEXT.split(" "));


    public static <E> Set<E> removeDuplicates(Collection<E> collection) {
        return new LinkedHashSet<>(collection);
    }

    public void demonstrateRemoveDuplication() {
        log.info("Before remove duplicate: {}", words);
        Collection<String> noDuplicates = new HashSet<>(words);
        log.info("After remove duplicate:  {}", noDuplicates);
    }

    public void demonstrateRemoveDuplicationWithStreaming() {
        log.info("Before remove duplicate: {}", words);
        Collection<String> noDuplicates = words.stream()
                                                .collect(Collectors.toSet());
        log.info("After remove duplicate:  {}", noDuplicates);
    }

    public void demonstrateRemoveDuplicationWithStreamingAndHashSet() {
        log.info("Before remove duplicate: {}", words);
        Collection<String> noDuplicates = words.stream()
                                                .collect(Collectors.toCollection(HashSet::new));
        log.info("After remove duplicate:  {}", noDuplicates);
    }

    public void demonstrateRemoveDuplicationWithStreamingAndTreeSet() {
        log.info("Before remove duplicate: {}", words);
        Collection<String> noDuplicates = words.stream()
                                                .collect(Collectors.toCollection(TreeSet::new));
        log.info("After remove duplicate:  {}", noDuplicates);
    }

    // preserves the order of the original collection 
    public void demonstrateRemoveDuplicationWithStreamingAndLinkedHashSet() {
        log.info("Before remove duplicate: {}", words);
        Collection<String> noDuplicates = words.stream()
                                                .collect(Collectors.toCollection(LinkedHashSet::new));
        log.info("After remove duplicate:  {}", noDuplicates);
    }

    public void demonstrateRemoveDuplicates() {
        log.info("Before remove duplicate: {}", words);
        Collection<String> noDuplicates = removeDuplicates(words);
        log.info("After remove duplicate:  {}", noDuplicates);
    }

    public static void main(String[] args) {
        SetDemo demo = new SetDemo() ;

        demo.demonstrateRemoveDuplication();
        demo.demonstrateRemoveDuplicationWithStreaming();
        demo.demonstrateRemoveDuplicationWithStreamingAndHashSet();
        demo.demonstrateRemoveDuplicationWithStreamingAndTreeSet();
        demo.demonstrateRemoveDuplicationWithStreamingAndLinkedHashSet();
        demo.demonstrateRemoveDuplicates();
    }
}
