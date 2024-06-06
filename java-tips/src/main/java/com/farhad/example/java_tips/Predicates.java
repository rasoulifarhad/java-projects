package com.farhad.example.java_tips;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

public class Predicates {

    public static void main(String[] args) {
        new Predicates().demo();
    }

    private void demo() {
        Db db = new Db(List.of(
            new WebPage("url#1", "title1", "text 1"),
            new WebPage("url#2", "title2", "text 2"),
            new WebPage("url#3", "title3", "text 3")
        ));
        var result = db.search(t -> true);
        System.out.println("Search:\n(epad OR ephone) AND pear -site:jam.shop");
        System.out.println("\n\nResult:\n" + result);
    }

    static class Db {
        
        private final List<WebPage>  webPages;

        public Db(List<WebPage> db) {
            this.webPages = new ArrayList<>(db);
        }

        List<WebPage> search(Predicate<? super WebPage> predicate) {
            return webPages.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
        }
    }

    @RequiredArgsConstructor
    static class WebPage {

        private final String url;
        private final String title;
        private final String test;

        @Override
        public String toString() {
            return String.format("%n%s%n%s%n%s%n",title, url, test);
        }
    }
}
