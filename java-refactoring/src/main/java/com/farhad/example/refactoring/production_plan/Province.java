package com.farhad.example.refactoring.production_plan;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Province {

    @Getter
    @Setter
    private String name;
    @Getter
    private List<Producer> producers;

    @Getter
    @Setter
    private int totalProduction;

    @Getter
    private int demand;
    @Getter
    private int price;

    public Province(Doc doc) {

        this.name = doc.name;
        producers = new ArrayList<>();
        totalProduction = 0;
        this.demand = doc.demand;
        this.price = doc.price;
        doc.producers.forEach(d -> this.addProducer(new Producer(this, d)));
    }

    private void addProducer(Producer producer) {
        this.producers.add(producer);
        this.totalProduction += producer.getProduction();

    }

    public void setDemand(String demand) {
        this.demand = Integer.parseInt(demand);
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }

    public int getShortfall() {
        return this.demand - this.totalProduction;
    }

    public int getProfit() {
        return getDemandValue() - getDemandCost();

    }

    static class RemainingDemand {

        public int value;

        public RemainingDemand(int value) {
            this.value = value;
        }

    }

    static class Result {
        public int value;

        public Result(int value) {
            this.value = value;
        }

    }

    private int getDemandCost() {
        RemainingDemand remainingDemand = new RemainingDemand(demand);
        Result result = new Result(0);

        this.producers.stream()
                .sorted((a, b) -> a.getCost() - b.getCost())
                .forEach(p -> {
                    int contribution = Math.min(remainingDemand.value, p.getProduction());
                    remainingDemand.value -= contribution;
                    result.value += contribution * p.getCost();
                });

        return result.value;
    }

    private int getSatisfiedSemand() {
        return Math.min(this.demand, this.totalProduction);
    }

    private int getDemandValue() {
        return getSatisfiedSemand() * this.price;
    }

}
