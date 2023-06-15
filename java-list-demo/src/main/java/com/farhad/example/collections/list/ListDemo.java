package com.farhad.example.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
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
    private Collection<String> _allWords = Arrays.asList(ALL_TEXT.split(" "));

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

    public static <E> void replace(List<E> list, E oldValue, E newValue) {
        Objects.requireNonNull(oldValue);
        Objects.requireNonNull(newValue);
        for (ListIterator<E> it = list.listIterator(); it.hasNext(); ) {
            E e = it.next();
            if( e == null ? true : oldValue.equals(e)) {
                it.set(newValue);
            }
        }
    }

    public static <E> void replaceList(List<E> list, E oldValue, List<? extends E> newValues) {
        Objects.requireNonNull(oldValue);
        Objects.requireNonNull(newValues);
        for (ListIterator<E> it = list.listIterator(); it.hasNext(); ) {
            E e = it.next();
            if( e == null? true : oldValue.equals(e)) {
                it.remove();
                for (E newE : newValues) {
                    it.add(newE);
                }
            }
        }
    }

    public static <E> List<E> dealHand(List<E> deck, int count) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - count, deckSize);
        List<E> hand = new ArrayList<>(handView);
        handView.clear();
        return hand;

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

    private <E> void printListWithPosition(List<E> list) {
        ListIterator<E> it = list.listIterator();
        int index;
        for (; it.hasNext();) {
            index = it.nextIndex();
            E word = it.next();
            System.out.printf("%d:[%s] ", index, word);
        }
        System.out.printf("%n");
    }

    public void demonstrateIndexOf() {
        List<String> list = new ArrayList<>(_allWords);
        // [i, came, i, saw, i, left, then, i, sleep, then, i, wakeup, then, i, came]
        log.info("");
        printListWithPosition(list);
        // log.info("list:      {}", list);
        String element = "i";
        log.info("First indexOf(`{}`): {}", element, list.indexOf(element));
        log.info("Last  indexOf(`{}`): {}", element, list.lastIndexOf(element));

        element = "left";
        log.info("First indexOf(`{}`): {}", element, list.indexOf(element));
        log.info("Last  indexOf(`{}`): {}", element, list.lastIndexOf(element));
        element = "then";
        log.info("First indexOf(`{}`): {}", element, list.indexOf(element));
        log.info("Last  indexOf(`{}`): {}", element, list.lastIndexOf(element));
    }

    public void demonstrateContainsAndContainsAll() {
        List<String> allList = new ArrayList<String>(_allWords);
        List<String> wordsList = new ArrayList<String>(words);
        List<String> secondList = new ArrayList<String>(secondWords);

        log.info("");
        log.info("Words  List: {}", wordsList);
        log.info("Second List: {}", secondList);
        log.info("All    List: {}", allList);
        log.info("");
        String element = "left";
        log.info("Words List  have {} element: '{}' ", wordsList.contains(element) ? "   " : "not", element);
        log.info("Second List have {} element: '{}' ", secondList.contains(element) ? "   " : "not", element);
        log.info("All List    have {} element: '{}' ", allList.contains(element) ? "   " : "not", element);
        element = "wakeup";
        log.info("");
        log.info("Words List  have {} element: '{}' ", wordsList.contains(element) ? "   " : "not", element);
        log.info("Second List have {} element: '{}' ", secondList.contains(element) ? "   " : "not", element);
        log.info("All List    have {} element: '{}' ", allList.contains(element) ? "   " : "not", element);

        log.info("");
        log.info("Words List  have {} element: '{}' ", wordsList.containsAll(words) ? "   " : "not", words);
        log.info("Second List have {} element: '{}' ", secondList.containsAll(words) ? "   " : "not", words);
        log.info("All List    have {} element: '{}' ", allList.containsAll(words) ? "   " : "not", words);

        List<String> shuffledWords = new ArrayList<>(words);
        Collections.shuffle(shuffledWords);
        log.info("");
        log.info("Words List  have {} element: '{}' ", wordsList.containsAll(shuffledWords) ? "   " : "not", shuffledWords);
        log.info("Second List have {} element: '{}' ", secondList.containsAll(shuffledWords) ? "   " : "not", shuffledWords);
        log.info("All List    have {} element: '{}' ", allList.containsAll(shuffledWords) ? "   " : "not", shuffledWords);
    }

    public void demonstrateReplaceAll() {
        List<String> wordsList = new ArrayList<String>(words);
        log.info("");
        log.info("Words  List: {}", wordsList);
        wordsList.replaceAll(String::toUpperCase);
        log.info("Words List(Uppercased): {}", wordsList);
    }

    public void demonstrateReplaceStaticMethod() {
        List<String> wordsList = new ArrayList<String>(words);
        log.info("");
        log.info("Words  List:             {}", wordsList);
        String val = "i";
        String newVal = "I";
        replace(wordsList, val, newVal);
        log.info("Words  List('{}' -> '{}'): {}", val, newVal, wordsList);
    }

    public void demonstrateReplaceListStaticMethod() {
        List<String> wordsList = new ArrayList<String>(words);
        log.info("");
        log.info("Words  List:             {}", wordsList);
        String val = "i";
        List<String> nevalues = Arrays.asList("When", "I") ;
        replaceList(wordsList, val, nevalues);
        log.info("Words  List('{}' -> '{}'): {}", val, nevalues, wordsList);
    }

    public void demonstrateSubList() {
        List<String> wordsList = new ArrayList<String>(words);
        log.info("");
        log.info("Words  List:     {}", wordsList);
        List<String> subWordsList =  wordsList.subList(2, 4);
        log.info("Sub Words  List: {}", subWordsList);
        subWordsList.clear();
        log.info("Words  List:     {}", wordsList);
        log.info("Sub Words  List: {}", subWordsList);

        wordsList = new ArrayList<String>(words);
        log.info("");
        log.info("Sub List: {}", wordsList.subList(2, 5));
        log.info("First index of '{}': {} ", "i", wordsList.subList(2,5).indexOf("i"));
        log.info("Last  index of '{}': {} ", "i", wordsList.subList(2,5).lastIndexOf("i"));
    }

    public void demonstrateDealHand() {
        String [] suit = new String[] { "spades", "hearts", "diamonds", "clubs" };
        String [] rank = new String[] {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
        List<String> deck = new ArrayList<>();
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                // deck.add(rank[j] + " of " + suit[i]);
                // deck.add(String.format("(%s)%s", rank[j], suit[i]));
                deck.add(String.format("%s_%s", rank[j], suit[i]));
            }
        }
        Collections.shuffle(deck);

        // numberOfHands * cardsPerHand must less than or equal deck.size()
        int numberOfHands = 4;
        int cardsPerHand  = 5;
        for (int i = 0; i < numberOfHands; i++) {
            log.info( "Cards in Hand#{}: {}", i, dealHand(deck, cardsPerHand) );
        }
    }

    public void demonstrateImmutableMultipleCopyOfSameElementList() {

        log.info("");
        List<String> list = new ArrayList<>(Collections.nCopies(1000, (String)null));
        log.info("List.size(): {}", list.size());

        String element = "Hello World";
        list.addAll(Collections.nCopies(80, element));
        log.info("List.size(): {}", list.size());

        list.removeAll(Collections.singletonList(element));
        log.info("List.size(): {}", list.size());
    }

    public static void main(String[] args) {
        ListDemo demo = new ListDemo();

        demo.demonstrateAddAll();
        demo.demonstrateStreamCollectTolist();
        demo.demonstrateSwapTwoIndexesInList();
        demo.demonstrateShuffleList();
        demo.demonstrateCollectionsShuffleList();
        demo.demonstrateListIterator();
        demo.demonstrateIndexOf();
        demo.demonstrateContainsAndContainsAll();
        demo.demonstrateReplaceAll();
        demo.demonstrateReplaceStaticMethod();
        demo.demonstrateReplaceListStaticMethod();
        demo.demonstrateSubList();
        demo.demonstrateDealHand();

        demo.demonstrateImmutableMultipleCopyOfSameElementList();
    }
}
