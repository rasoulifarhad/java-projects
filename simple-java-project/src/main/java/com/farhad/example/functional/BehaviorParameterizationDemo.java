package com.farhad.example.functional;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class BehaviorParameterizationDemo {
    

    public static List<Book> findLongNovels(List<Book> library) {
        List<Book> longNovels = new ArrayList<>();
        for (Book book : library) {
            if (book.getPageCount() > 200) {
                longNovels.add(book);
            }
        }
        return longNovels;
    }

    public static List<Book> filterBooksByAuthor(List<Book> library, String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : library) {
            if(author.equals(book.getAuthor())) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }

    public static List<Book> filterBook(List<Book> library, BookPredicate predicate) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : library) {
            if(predicate.test(book)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public static List<Book> filterBookWithPredicate(List<Book> library, Predicate<Book> predicate) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : library) {
            if(predicate.test(book)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    @Data
    @AllArgsConstructor
    static class Book {
        private String name;
        private int pageCount;
        private String author;

    }

    interface BookPredicate {
        boolean test(Book book);
    }

    @RequiredArgsConstructor
    static class Lengthredicate implements BookPredicate {
        private final int length;

        @Override
        public boolean test(Book book) {
            return book.getPageCount() > length;
        }
    }

    @RequiredArgsConstructor
    static class AuthorPredicate implements BookPredicate {
        private final String author;
        @Override
        public boolean test(Book book) {
            return author.equals(book.getAuthor());
        }
    }

    public static void main(String[] args) {

        List<Book> library = new ArrayList<>();
        library.add(new Book("Moby Dick", 250, "Herman Melville"));
        library.add(new Book("Alice's Adventures in Wonderland", 190, "Lewis Carrol"));
        library.add(new Book("Sylvie and Bruno", 400, "Lewis Carrol"));

        BookPredicate lengthPredicate = new Lengthredicate(200);
        BookPredicate authorPredicate = new AuthorPredicate("Lewis Carrol");
        System.out.println(filterBook(library, lengthPredicate));
        System.out.println(filterBook(library, authorPredicate));

        System.out.println(
            filterBook(library, new BookPredicate(){

                @Override
                public boolean test(Book book) {
                    return "Lewis Carrol".equals(book.getAuthor());
                }

            })            
        );

        System.out.println(
            filterBookWithPredicate(library, book ->  "Lewis Carrol".equals(book.getAuthor()) )
        );
        System.out.println(
            library
                .stream()
                .filter(b ->"Lewis Carrol".equals(b.getAuthor()) )
                .collect(toList())
        );
    }
}
