package com.farhad.example.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    
    public static void main(String[] args) {
        int n = 7;
        System.out.println("Fibo " + n + ": " + fiboRec(n));
        System.out.println("Fibo " + n + ": " + fiboMemoizedPosition(n));

        n = 2;
        System.out.println("Fibo " + n + ": " + fiboRec(n));
        System.out.println("Fibo " + n + ": " + fiboMemoizedPosition(n));

        n = 1;
        System.out.println("Fibo " + n + ": " + fiboRec(n));
        System.out.println("Fibo " + n + ": " + fiboMemoizedPosition(n));

        n = 0;
        System.out.println("Fibo " + n + ": " + fiboRec(n));
        System.out.println("Fibo " + n + ": " + fiboMemoizedPosition(n));

    }


    public static int fiboRec(int n) {
        return (n < 2) ? n : fiboRec(n - 1) + fiboRec(n - 2);
    }

    public static int fiboMemoizedPosition(int n) {
        List<Integer> memo = new ArrayList<>();
        memo.add(0);
        memo.add(1);
        int memorizedIndex = memo.size();
        int res = 0;
        if(memorizedIndex > n ) {
            return memo.get(n);
        }
        while (n >= memorizedIndex ) {
            res = memo.get(memorizedIndex - 1) + memo.get(memorizedIndex -2);
            memo.add(res);
            memorizedIndex++;
        }
        return res;
    }
}
