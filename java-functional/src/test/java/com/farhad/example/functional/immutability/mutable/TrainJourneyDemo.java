package com.farhad.example.functional.immutability.mutable;

import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.Data;

public class TrainJourneyDemo {

    @AllArgsConstructor
    @Data
    static class TrainJourney {

        private  int price;
        private  TrainJourney onward;

    }

    static class TrainJourneySupport {

        public static TrainJourney link(TrainJourney start, TrainJourney continuation) {
            if (start == null) {
                return continuation;
            }

            TrainJourney t = start;
            if (t.getOnward() != null) {
                t = t.getOnward();
            }

            t.setOnward(continuation);
            return start;
        }

        public static void visit(TrainJourney trainJourney, Consumer<TrainJourney> consumer) {
            if (trainJourney != null) {
                consumer.accept(trainJourney);
                visit(trainJourney.getOnward(), consumer);
            }
        }
    }

    public static void main(String[] args) {
        // TrainJourney continuation = new TrainJourney(10, null);
        // TrainJourney start = TrainJourneySupport.link(null, continuation);       
        // TrainJourney second = TrainJourneySupport.link(start, new TrainJourney(20, null));
        // TrainJourneySupport.visit(second, t -> System.out.println(t.getPrice() + " - "));

        TrainJourney start = new TrainJourney(10, null);
        TrainJourney continuation = new TrainJourney(20, null);
        TrainJourney startJourney = TrainJourneySupport.link(start, continuation);       
        TrainJourney secondJourney = TrainJourneySupport.link(start, continuation);
        TrainJourneySupport.visit(secondJourney, t -> System.out.println(t.getPrice() + " - "));
    }

}
