package com.farhad.example.quiz;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

public class AndThenQuizDemo {
    
    private AndThenQuizDemo() {

    }
    static class Value {
        static Integer counterC = 1;
        static Integer counterF = 1;

        private Value() {
        }
    }

    static class ChainTest {

        public static void main(String[] args) {
            Consumer<Integer> addC = i -> Value.counterC += i;
            Consumer<Integer> showC =  i -> System.out.println(i);

            System.out.println();
            addC.andThen(showC).accept(1);

            IntConsumer addIntToC = i -> Value.counterC += i;
            IntConsumer showIntForC = i -> System.out.println(i);
            System.out.println();
            addIntToC.andThen(showIntForC).accept(1);

            Function<Integer, Integer> addF = i -> Value.counterF +=i;
            Function<Integer, Integer> showF = i ->  {
                System.out.println(i);
                return i;
            };

            System.out.println();
            addF.andThen(showF).apply(1);
        }
    }
}
