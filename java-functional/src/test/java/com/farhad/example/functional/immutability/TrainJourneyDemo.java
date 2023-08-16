package com.farhad.example.functional.immutability;

import java.util.function.Consumer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class TrainJourneyDemo {
    
    @RequiredArgsConstructor
    @Getter
    @ToString
    @EqualsAndHashCode
    static class TrainJourney {

        private final int price;
        private final TrainJourney onward;

        public TrainJourney withPrice(int price) {
            return new TrainJourney(price, getOnward());
        }

        public TrainJourney withOnward(TrainJourney omward) {
            return new TrainJourney(getPrice(), omward);
        }
    }

    static class TrainJourneySupport {

        public static TrainJourney link(TrainJourney start, TrainJourney continuation) {

            return start == null ? continuation 
                                 : new TrainJourney(start.getPrice(), link(start.getOnward(), continuation));
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
