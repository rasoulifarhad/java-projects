package com.farhad.example.codekata.productarrayexceptself;

import java.util.StringJoiner;

public class ProductOfArrayExceptSelfDemo02 {
    
    static class Solution {

        public int [] productArray(int [] ints) {

            int [] res = new int [ints.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = 1;
            }

            for (int i = 0; i < ints.length; i++) {
                for (int j = 0; j < ints.length; j++) {
                    if ( i == j ) {
                        continue;
                    }
                    res[i] *= ints[j];
                }
            }
            return res;
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
