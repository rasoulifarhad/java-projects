package com.farhad.example.java8idioms.consumerandthen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.Data;

public class ConsumerAndThenDemo {
    
    public static void main(String[] args) {
        List<Trader> traders = new ArrayList<>();
        for (int i = 0; i < 10; i++  ) {    
            traders.add(new Trader((new Random().nextInt(100) + 1) * 3 ));
        }

        traders.forEach(System.out::println);
        Consumer<Trader> consumer1 = new Consumer<Trader>() {

            @Override
            public void accept(Trader trader) {
                trader.updateBonus(2);
            }
        };


        Consumer<Trader> consumer2 = new Consumer<Trader>() {

            @Override
            public void accept(Trader trader) {
                System.out.println(trader);
            }
        };

        System.out.println();
        traders.forEach(trader -> consumer1.andThen(consumer2).accept(trader));
    }

    @Data
    @AllArgsConstructor
    static class Trader {
        private int units;

        public void updateBonus(int bonusUnits) {
            this.units = this.units * bonusUnits;
        }
    }

}
