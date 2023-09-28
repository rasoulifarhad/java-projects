package com.farhad.example.Knapsack_problem;

import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {
    
    public void knapsackGreProc(int W[], int V[], int M, int n) {
        KnapsackPackage[] packages = new KnapsackPackage[n];
        for (int i = 0; i < n; i++) {
            packages[i] = new KnapsackPackage((double)W[i], (double)V[i]);
        }
        Arrays.sort(packages, new Comparator<KnapsackPackage>() {

            public int compare(KnapsackPackage o1, KnapsackPackage o2) {
                return o2.getCost().compareTo(o1.getCost());
            }
        });
        int remain = M;
        double result = 0d;
        int i = 0;
        boolean stopProc = false;
        while (!stopProc) {
            if(packages[i].getWeight() <= remain) {
                remain -= packages[i].getWeight();
                result += packages[i].getValue();
                System.out.println( String.format("Pack %d - Weight %.2f - Value %.2f", 
                                        i, 
                                        packages[i].getWeight(),
                                        packages[i].getValue()));
            }
            if(packages[i].getWeight() > remain) {
                i++;
            }
            if(i == n) {
                stopProc = true;
            }
        }

        System.out.println("Max Value:\t" + result);
    }
}
