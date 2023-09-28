package com.farhad.example.Knapsack_problem_0_1;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Item {
    private final String name;
    private final int weight;
    private final double value;

    @Override
    public String toString() {
        return String.format("item(%s, %s, %s)", name, weight, value);
    }

    
}
