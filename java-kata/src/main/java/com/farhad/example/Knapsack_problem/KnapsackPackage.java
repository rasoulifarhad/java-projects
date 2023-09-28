package com.farhad.example.Knapsack_problem;

import lombok.Getter;

@Getter
public class KnapsackPackage {
    private final Double weight;
    private final Double value;
    private Double cost;

    public KnapsackPackage(Double weight, Double value) {
        this.weight = weight;
        this.value = value;
        this.cost = new Double(value / weight);

    }

    
}
