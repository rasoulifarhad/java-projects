package com.farhad.example.codekata.productarrayexceptself;

import java.util.StringJoiner;

public class ProductOfArrayExceptSelfDemo {
    
    static class Solution {
        public int [] productArray(int [] ints) {
            int [] intsResult = new int [ints.length];
            for (int i = 0; i < intsResult.length; i++) {
                int product = 1;
                for (int j = 0; j < intsResult.length; j++) {
                    if ( i != j ) {
                        product = ints[j] * product;
                    }
                }
                intsResult[i] = product;
            }
            return intsResult;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int [] ints = {1, 2, 3, 4};
        int [] res = solution.productArray(ints);
        System.out.println(toString(ints) + " -> " + toString(res));

        ints = new int[] {4, 2, 1, 5, 3};
        res = solution.productArray(ints);
        System.out.println(toString(ints) + " -> " + toString(res));

        ints = new int[] {1, 1, 1, 1, 1};
        res = solution.productArray(ints);
        System.out.println(toString(ints) + " -> " + toString(res));

        ints = new int[] {0, 0, 0, 0, 0};
        res = solution.productArray(ints);
        System.out.println(toString(ints) + " -> " + toString(res));

        ints = new int[] {2, 3, 0, 4};
        res = solution.productArray(ints);
        System.out.println(toString(ints) + " -> " + toString(res));
    }


    private static String toString(int [] ints) {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (int i : ints) {
            joiner.add(Integer.toString(i));
        }
        return joiner.toString();
    }

}
