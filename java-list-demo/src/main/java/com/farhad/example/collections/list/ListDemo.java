package com.farhad.example.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListDemo {
    
    private static final String TEXT = "i came i saw i left";
    private Collection<String> words = Arrays.asList(TEXT.split(" "));

    private static final String TEXT2 = "then i sleep then i wakeup then i came";
    private Collection<String> secondWords = Arrays.asList(TEXT2.split(" "));

    private static final String ALL_TEXT = "i came i saw i left then i sleep then i wakeup then i came";

    public static <E> void swap(List<E> list, int i, int j) {

        E tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static void shuffle(List<?> list, Random rnd) {
        for (int i = list.size(); i > 1; i--) {
            swap(list, i-1, rnd.nextInt(i));
        }
    }

    public static void shuffle(List<?> list) {
        Random rnd = new Random();
        for (int i = list.size(); i > 1; i--) {
            swap(list, i-1, rnd.nextInt(i));
        }
    }

    public void demonstrateAddAll() {
        List<String> allList = new ArrayList<>(words);
        log.info("");
        log.info("Before addAll: {}", allList);
        allList.addAll(secondWords);
        log.info("After addAll:  {}",allList);
    }

    public void demonstrateStreamCollectTolist() {
        log.info("");
        List<String> transfredList =  words.stream()
                                                .map(String::toUpperCase)
                                                .collect(Collectors.toList());
        log.info("List:           {}", words);
        log.info("Transfred List: {}", transfredList);
    }

    public void demonstrateSwapTwoIndexesInList() {
        List<String> list = new ArrayList<>(words);
        log.info("");
        log.info("Before swap:        {}", list);
        swap(list, 0, 3);
        log.info("After swap({} -> {}): {}", 0, 3, list);
    }

    public void demonstrateShuffleList() {
        List<String> list = new ArrayList<>(words);
        list.addAll(secondWords);
        log.info("");
        log.info("Before shuffle:      {}", list);
        shuffle(list, new Random());
        log.info("After shuffle:       {}", list);

        list = new ArrayList<>(words);
        list.addAll(secondWords);
        shuffle(list, new Random());
        log.info("After shuffle:       {}", list);

        list = new ArrayList<>(words);
        list.addAll(secondWords);
        shuffle(list, new Random());
        log.info("After shuffle:       {}", list);

        list = new ArrayList<>(words);
        list.addAll(secondWords);
        shuffle(list, new Random());
        log.info("After shuffle:       {}", list);

        List<String> allWords = Arrays.asList(ALL_TEXT.split(" "));
        shuffle(allWords, new Random());
        log.info("After shuffle:       {}", allWords);
    }

    public void demonstrateCollectionsShuffleList() {
        List<String> allWords = Arrays.asList(ALL_TEXT.split(" "));
        log.info("");
        log.info("Before shuffle:      {}", allWords);
        Collections.shuffle(allWords);
        log.info("After shuffle:       {}", allWords);
    }

    public void demonstrateListIterator() {
        List<String> list = new ArrayList<>(words);
        ListIterator<String> it =  list.listIterator();
        int index ;

        log.info("");
        log.info("Start Iterate with it.previous(): {}", list);
        for (; it.hasPrevious();) {
            index = it.previousIndex();
            String word = it.previous();
            System.out.printf("%d:%s ", index, word);
        }
        System.out.printf("%n");
        log.info("End iterate with it.previous()", list);
        log.info("");
        log.info("Start Iterate with it.next(): {}", list);
        for (; it.hasNext();) {
            index = it.nextIndex();
            String word = it.next();
            System.out.printf("%d:%s ", index, word);
        }
        System.out.printf("%n");
        log.info("End iterate with it.next()", list);

        it = list.listIterator(list.size());
        log.info("");
        log.info("Start Iterate with it.previous(): {}", list);
        for (; it.hasPrevious();) {
            index = it.previousIndex();
            String word = it.previous();
            System.out.printf("%d:%s ", index, word);
        }
        System.out.printf("%n");
        log.info("End iterate with it.previous()", list);
    }

    public static void main(String[] args) {
        ListDemo demo = new ListDemo();

        demo.demonstrateAddAll();
        demo.demonstrateStreamCollectTolist();
        demo.demonstrateSwapTwoIndexesInList();
        demo.demonstrateShuffleList();
        demo.demonstrateCollectionsShuffleList();
        demo.demonstrateListIterator();
    }
}
