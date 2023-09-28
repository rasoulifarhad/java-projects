package com.farhad.example.Knapsack_problem;

import org.junit.jupiter.api.Test;

public class knapsackTest {

    @Test
    void test1() {
        int W[] = new int[]{15, 10, 2, 4};
            
        int V[] = new int[]{30, 25, 2, 6};

        int M = 37;

        int n = V.length;

        Knapsack knapsack = new Knapsack();
        knapsack.knapsackGreProc(W, V, M, n);
    }

    @Test
    void test2() {
        int W[] = new int[]{12, 2, 1, 1, 4};
            
        int V[] = new int[]{4, 2, 1, 2, 10};   
        
        int M = 15;
        int n = V.length;

        Knapsack knapsack = new Knapsack();
        knapsack.knapsackGreProc(W, V, M, n);
    }

}
