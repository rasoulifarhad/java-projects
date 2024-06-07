package com.farhad.example.java_tips;

import static java.util.stream.Collectors.toList;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

public class Combinator {

    public static void main(String[] args) {
        new Combinator().demo();
    }

    private void demo() {

        ZonedDateTime date = ZonedDateTime.now();
        List<Blog> blogs = List.of(
            new Blog("bbcpersian",Date.from(date.minusHours(1).toInstant()), 
                "BBC Persian is the Persian language broadcast station and subsidiary of \n" + 
                "BBC World Service which conveys the latest political, social, economical and \n" + 
                "sport news relevant to Iran, Afghanistan, and Tajikistan, and the world. Its \n" + 
                "headquarters are in London, United Kingdom."),
            new Blog("radiofarda",Date.from(date.toInstant()) , 
                "Radio Farda is the Iranian branch of the U.S. government-funded Radio \n" + 
                "Free Europe/Radio Liberty (RFE/RL) external broadcast service for \n" + 
                "providing \"factual, objective and professional journalism\" to its \n" + 
                "audiences. It broadcasts 24 hours a day in the Persian language from its \n" + 
                "headquarters in the district Hagibor of Prague, Czech Republic."),
            new Blog("dzone", Date.from(date.minusHours(2).toInstant()), 
                "DZone.com is one of the world's largest online communities and \n" + 
                "leading publisher of knowledge resources for software engineering \n" + 
                "professionals. Every day, thousands of developers come to DZone.com to \n" + 
                "read about the latest technology trends and learn about new \n" + 
                "technologies, methodologies, and best practices through shared knowledge.")
        );

        Function<List<Blog>, List<Page>> breakIntoPages = Page::breakIntoPages;

        Function<List<Blog>, List<Blog>> shorten = l -> l.stream().map(ShortendBlog::new).collect(toList()); 
        Function<List<Blog>, List<Page>> collapse = shorten.andThen(breakIntoPages);
        System.out.println("---------- Collapsd pages ----------");
        System.out.println();
        printPages(collapse.apply(blogs));

        Function<List<Blog>, List<Blog>> sortByDate = l -> 
            l.stream()
                .sorted((b1, b2) -> b1.date.compareTo(b2.date))
                .collect(toList()); 
        Function<List<Blog>, List<Page>> expand = sortByDate.andThen(breakIntoPages);
        System.out.println("---------- Expanded pages ----------");
        System.out.println();
        printPages(expand.apply(blogs));
    }

    private void printPages(List<Page> pages) {
        for (int i = 0; i < pages.size(); i++) {
            Page page = pages.get(i);
            System.out.println("\nPage " + (i+1) + "\n");
            System.out.println(page);
        }
    }

    static class Page {
        final static long capacity = 10;
        long size;
        final List<Blog> blogs;

        Page() {
            size = 0;
            blogs = new ArrayList<>();
        }

        Page(List<Blog> blogs) {
            this.blogs = blogs;
            this.size = blogs.stream().mapToLong(b -> b.content.lines().count()).sum();
        }

        static List<Page> breakIntoPages(List<Blog> blogs) {
            var pages = new ArrayList<Page>();
            pages.add(new Page());
            for (Blog blog : blogs) {
                if (false == pages.get(pages.size() - 1).add(blog)) {
                    List<Blog> list = new ArrayList<>();
                    list.add(blog);
                    pages.add(new Page(list));
                }
            }
            return pages;
        }

        private boolean add(Blog blog) {
            if(size + blog.content.lines().count() <= capacity){
                size += blog.content.lines().count();
                blogs.add(blog);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return "" + blogs.stream().map(Objects::toString).collect(Collectors.joining("\n")) + "\n";
        }

        
    }

    @AllArgsConstructor
    static class Blog {
    
        private String author;
        private Date date;
        private String content;
        
        @Override
        public String toString() {
            return String.format("%n%s%n%s, %s", content, author.toUpperCase(), date);
        }
    }

    static class ShortendBlog extends Blog {

        public ShortendBlog(Blog blog) {
            super(blog.author, blog.date, blog.content.lines().findFirst().get() + " ...");
        }

    }
}
