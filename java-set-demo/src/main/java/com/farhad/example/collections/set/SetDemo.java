package com.farhad.example.collections.set;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SetDemo {
    
    private static final String TEXT = "i came i saw i left";
    private Collection<String> words = Arrays.asList(TEXT.split(" "));

    private static final String TEXT2 = "then i sleep then i wakeup then i came";
    private Collection<String> secondWords = Arrays.asList(TEXT2.split(" "));


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

    public void demonstrateBulkOperationsAddAll() {
        log.info("");
        log.info("First words:  {}", words);
        log.info("Second words: {}", secondWords);
        log.info("");

        Set<String> union = new HashSet<>(words);
        union.addAll(secondWords);
        log.info("Union:        {}", union);
    } 

    public void demonstrateBulkOperationsRetainAll() {
        log.info("");
        log.info("First words:  {}", words);
        log.info("Second words: {}", secondWords);
        log.info("");

        Set<String> intersection = new HashSet<>(words);
        intersection.retainAll(secondWords);
        log.info("Intersection: {}", intersection);
    }

    public void demonstrateBulkOperationsRemoveAll() {
        log.info("");
        log.info("First words:  {}", words);
        log.info("Second words: {}", secondWords);
        log.info("");

        Set<String> difference = new HashSet<>(words);
        difference.removeAll(secondWords);
        log.info("Difference:   {}", difference);
    }

    public void demonstrateExtractDuplicates() {

        log.info("");
        log.info("words:      {}", words);
        log.info("");
        Set<String> uniques = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (String s : words) {
            if (!uniques.add(s)) {
                duplicates.add(s);
            }
        }
        log.info("Duplicates: {}", duplicates);
    }

    public void demonstrateExtractNonDuplicates() {

        log.info("");
        log.info("words:          {}", words);
        log.info("");
        Set<String> uniques = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (String s : words) {
            if (!uniques.add(s)) {
                duplicates.add(s);
            }
        }
        Set<String> noneDuplicates = new HashSet<>(uniques);
        noneDuplicates.removeAll(duplicates);
        
        log.info("Non Duplicates: {}", noneDuplicates);
    }

    // The set of elements contained in either of two specified sets but not in both.
    public void demonstrateSymmetricSetDifference() {
        log.info("");
        log.info("First words:  {}", words);
        log.info("Second words: {}", secondWords);
        log.info("");

        Set<String> symmetricDifference = new HashSet<>(words);
        symmetricDifference.addAll(secondWords);
        Set<String> intersection = new HashSet<>(words);
        intersection.retainAll(secondWords);
        symmetricDifference.removeAll(intersection);
        log.info("Symmetric Difference: {}", symmetricDifference);
    }

    public void demonstrateHowManyWordsBeginWithEachLetterWithSortedSet() {
        SortedSet<String> dictionary = getDictionary();
        log.info("");
        for (char ch = 'a'; ch <= 'z';) {
            String from = String.valueOf(ch++);
            String to = String.valueOf(ch);
            int count = dictionary.subSet(from, to).size();
            log.info("Number of words started with '{}': {}", from, count);
        }
    }


    public void demonstrateHowManyWordsBeginWithRangeClosedLetterWithSortedSet() {
        SortedSet<String> dictionary = getDictionary();
        char fromChar = 'b';
        char toChar = 'c';
        log.info("");
        String from = String.valueOf(fromChar++);
        String to = String.valueOf(toChar);
        int count = dictionary.subSet(from, to).size();
        log.info("Number of words started with '{}': {}", from, count);
        String toClosed = String.valueOf(toChar + "\0");
        count = dictionary.subSet(from, toClosed).size();
        log.info("Number of words started with '{}': {} closed", from, count);
    }

    public void demonstrateHowManyWordsBetweenEndpointsWithSortedSet() {
        SortedSet<String> dictionary = getDictionary();
        log.info("");
        String from = "doorbell";
        String to = "pickle";
        int count = dictionary.subSet(from, to).size();
        log.info("Number of words Between ['{}', '{}') : {}", from, to, count);
    }

    public void demonstrateHowManyWordsBetweenIncludingEndpointsWithSortedSet() {
        SortedSet<String> dictionary = getDictionary();
        log.info("");
        String from = "doorbell";
        String to = "pickle\0";
        int count = dictionary.subSet(from, to).size();
        log.info("Number of words Between ['{}', '{}'] : {}", from, to, count);
    }

    //  Open interval: which contains neither endpoint
    public void demonstrateHowManyWordsBetweenIncludingNeitherEndpointsWithSortedSet() {
        SortedSet<String> dictionary = getDictionary();
        log.info("");
        String from = "doorbell\0";
        String to = "pickle";
        int count = dictionary.subSet(from, to).size();
        log.info("Number of words Between ('{}', '{}') : {}", from, to, count);
    }

    private SortedSet<String> getDictionary() {
        SortedSet<String> dictionary = new TreeSet<>();
        URL url = this.getClass().getResource("dictionary.txt");
        try {
            Scanner s = new Scanner(new File(url.getFile()));
            while (s.hasNextLine()) {
                dictionary.add(s.next());
            }            
            s.close();
        } catch (Exception e) {
            log.error("Error", e);
        }
        return dictionary;
    }

    public static void main(String[] args) {
        SetDemo demo = new SetDemo() ;

        demo.demonstrateRemoveDuplication();
        demo.demonstrateRemoveDuplicationWithStreaming();
        demo.demonstrateRemoveDuplicationWithStreamingAndHashSet();
        demo.demonstrateRemoveDuplicationWithStreamingAndTreeSet();
        demo.demonstrateRemoveDuplicationWithStreamingAndLinkedHashSet();
        demo.demonstrateRemoveDuplicates();

        demo.demonstrateBulkOperationsAddAll();
        demo.demonstrateBulkOperationsRetainAll();
        demo.demonstrateBulkOperationsRemoveAll();

        demo.demonstrateExtractDuplicates();
        demo.demonstrateExtractNonDuplicates();

        demo.demonstrateSymmetricSetDifference();

        demo.demonstrateHowManyWordsBeginWithEachLetterWithSortedSet();
        demo.demonstrateHowManyWordsBeginWithRangeClosedLetterWithSortedSet();
        demo.demonstrateHowManyWordsBetweenEndpointsWithSortedSet();
        demo.demonstrateHowManyWordsBetweenIncludingEndpointsWithSortedSet();
        demo.demonstrateHowManyWordsBetweenIncludingNeitherEndpointsWithSortedSet();
    }
}
