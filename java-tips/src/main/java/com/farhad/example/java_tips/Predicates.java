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
            new WebPage("https://www.bbc.com/persian", "Persian language broadcast station and subsidiary of BBC World Service", "BBC Persian is the Persian language broadcast station and subsidiary of BBC World Service which conveys the latest political, social, economical and sport news relevant to Iran, Afghanistan, and Tajikistan, and the world. Its headquarters are in London, United Kingdom."),
            new WebPage("https://www.radiofarda.com/", "It broadcasts 24 hours a day in the Persian language from its headquarters in the district Hagibor of Prague, Czech Republic.", "Radio Farda is the Iranian branch of the U.S. government-funded Radio Free Europe/Radio Liberty (RFE/RL) external broadcast service for providing \"factual, objective and professional journalism\" to its audiences. It broadcasts 24 hours a day in the Persian language from its headquarters in the district Hagibor of Prague, Czech Republic."),
            new WebPage("https://dzone.com/", "Read, comment, share, or submit your own article, structured around the appropriate SDLC stage and focus area, to discuss technical topics and techniques.", "DZone.com is one of the world's largest online communities and leading publisher of knowledge resources for software engineering professionals. Every day, thousands of developers come to DZone.com to read about the latest technology trends and learn about new technologies, methodologies, and best practices through shared knowledge.")
        ));
        var result = db.search(
            (contains("persian").or(contains("article")))
                .and(contains("and"))
                .and(Predicate.not(contains("dzone")))
        );
        System.out.println("\n\nResult:\n" + result);
    }

    Predicate<WebPage> contains(String s) {
        return titleContains(s).or(textContains(s));
    }

    Predicate<WebPage> urlContains(String s) {
        return webPage -> webPage.url.toLowerCase().contains(s.toLowerCase()) ;
    }
    Predicate<WebPage> titleContains(String s) {
        return webPage -> webPage.title.toLowerCase().contains(s.toLowerCase()) ;
    }
    Predicate<WebPage> textContains(String s) {
        return webPage -> webPage.text.toLowerCase().contains(s.toLowerCase()) ;
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
        private final String text;

        @Override
        public String toString() {
            return String.format("%n%s%n%s%n%s%n",title, url, text);
        }
    }
}
