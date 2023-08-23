package com.farhad.example.java8idioms.consumerandthen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Data;

public class ConsumerAndThenDemo {
    
    public static void main(String[] args) {
        List<Trader> traders = new ArrayList<>();
        for (int i = 0; i < 10; i++  ) {    
            traders.add(new Trader((new Random().nextInt(100) + 1) * 3 ));
        }

        traders.forEach(System.out::println);
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
