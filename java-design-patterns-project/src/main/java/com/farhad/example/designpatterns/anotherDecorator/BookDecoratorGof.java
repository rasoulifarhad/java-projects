package com.farhad.example.designpatterns.anotherDecorator;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

public class BookDecoratorGof {
    
    interface Book {
        String describe();
    }

    public static class BasicBook implements Book {

        @Override
        public String describe() {
            return "Book";
        }
    }

    @RequiredArgsConstructor
    public abstract static class BookDecorator implements Book {
        final Book book;

        @Override
        public String describe() {
            return book.describe();
        }
    }

    public static class FictionBookDecorator extends BookDecorator {

        public FictionBookDecorator(Book book) {
            super(book);
        }

        @Override
        public String describe() {
            return "Fiction " + super.describe();
        }
    }

    public static class ScienceBookDecorator extends BookDecorator {

        public ScienceBookDecorator(Book book) {
            super(book);
        }

        @Override
        public String describe() {
            return "Science " + super.describe();
        }
    }

    public static class SoftCoverBookDecorator extends BookDecorator {

        public SoftCoverBookDecorator(Book book) {
            super(book);
        }

        @Override
        public String describe() {
            return super.describe() + " with Coft Cover";
        }
    }

    public static class HardCoverBookDecorator extends BookDecorator {

        public HardCoverBookDecorator(Book book) {
            super(book);
        }

        @Override
        public String describe() {
            return super.describe() + " with Hard Cover";
        }
    }

    public static void main(String[] args) {
        
        BasicBook book = new BasicBook();

        FictionBookDecorator fictionBook = new FictionBookDecorator(book);
        HardCoverBookDecorator hardCoverBook = new HardCoverBookDecorator(book);
        HardCoverBookDecorator hardCoverFictionBook = new HardCoverBookDecorator(fictionBook);
        ScienceBookDecorator scienceBook = new ScienceBookDecorator(book);
        HardCoverBookDecorator hardCoverScienceBook = new HardCoverBookDecorator(scienceBook);

        List<Book> bookList = new ArrayList<Book>() {
            {
                add(book);
                add(fictionBook);
                add(hardCoverBook);
                add(hardCoverFictionBook);
                add(scienceBook);
                add(hardCoverScienceBook);
            }
        };
        for(Book b : bookList ) {
            System.out.println(b.describe());
        }
    }
}
