package com.farhad.example.designpatterns.anotherDecorator;

import java.util.ArrayList;
import java.util.List;

public class BookDecoratorLambda {
    
    interface Book {
        String describe();
    }

    public static class BasicBook implements Book {

        @Override
        public String describe() {
            return "Book";
        }
    }

    public static void main(String[] args) {
        BasicBook book = new BasicBook();

        Book fictionBook = () -> "Fiction " + book.describe();
        Book hardCoverBook = () -> book.describe() + " with Hard Cover";
        Book hardCoverFictionBook = () -> fictionBook.describe() + " with Hard Cover";
        Book scienceBook =  () ->  "Science " + book.describe();
        Book hardCoverScienceBook = () -> scienceBook.describe() + " with Hard Cover";

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
        bookList.forEach(b -> System.out.println(b.describe()));
    }
}
