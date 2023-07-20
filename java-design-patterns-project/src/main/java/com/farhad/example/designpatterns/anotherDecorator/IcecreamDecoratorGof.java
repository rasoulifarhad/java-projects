package com.farhad.example.designpatterns.anotherDecorator;

import lombok.RequiredArgsConstructor;

public class IcecreamDecoratorGof {
    
    interface Icecream {
        public String makeIcecream();
    }

    static class SimpleIcecream implements Icecream {

        @Override
        public String makeIcecream() {
            return "Basic Icecream";
        }
    }

    @RequiredArgsConstructor
    static class IcecreamDecorator implements Icecream {
        protected final Icecream specialIcecream;
        @Override
        public String makeIcecream() {
            return specialIcecream.makeIcecream();
        }
    }

    static class HoneyDecorator extends IcecreamDecorator {

        public HoneyDecorator(Icecream specialIcecream) {
            super(specialIcecream);
        }

        @Override
        public String makeIcecream() {
            return specialIcecream.makeIcecream() + addHoney();
        }

        private String addHoney(){
            return " + sweet honey";
        }
    }

    static class NuttyDecorator extends IcecreamDecorator {

        public NuttyDecorator(Icecream specialIcecream) {
            super(specialIcecream);
        }

        @Override
        public String makeIcecream() {
            return specialIcecream.makeIcecream() + addNuts();
        }

        private String addNuts() {
            return " + cruncy nuts";
        }
    }

    public static void main(String[] args) {
        Icecream icecream = 
            new HoneyDecorator(
                new NuttyDecorator(
                    new SimpleIcecream()
                ));
        System.out.println(icecream.makeIcecream());
    }
}
