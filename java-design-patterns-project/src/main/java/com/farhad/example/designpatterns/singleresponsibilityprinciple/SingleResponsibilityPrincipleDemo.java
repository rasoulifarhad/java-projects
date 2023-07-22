package com.farhad.example.designpatterns.singleresponsibilityprinciple;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class SingleResponsibilityPrincipleDemo {
    

    @Data
    static class BadText {
        String text;
        String author;
        int length;

        void allLettersToUpperCase() {

        }

        void findSubTextAndDelete(String s) {

        }

        void printText() {

        }
    }

    @Data
    static class GoodText {

        String text;
        String author;
        int length;

        void allLettersToUpperCase() {

        }

        void findSubTextAndDelete(String s) {

        }
    }


    @RequiredArgsConstructor
    static class Printer {
        private final GoodText text;
        
        void printText() {

        }
    } 
}
