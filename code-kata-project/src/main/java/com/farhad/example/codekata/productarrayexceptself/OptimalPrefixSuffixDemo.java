package com.farhad.example.codekata.productarrayexceptself;

import java.util.StringJoiner;

public class OptimalPrefixSuffixDemo {
    
    // Given [x1, x2, x3, x4 x5, x6]
    // First pass : answer [1, x1, x1 * x2 , ......, x1 * x2 * x3 * x4 * x5] Prefix
    // Second Pass :   .....
    static class Solution{

        public int [] productArray(int [] ints) {

            int size = ints.length;
            int [] res = new int[size];

            int prefix = 1;
            for (int i = 0; i < size; i++) {            
                res[i] = prefix ;
                prefix = prefix * ints[i];
            }

            int suffix = 1;
            for (int j = size -1 ; j >= 0; j--) {
                res[j] = res[j] * suffix;
                suffix = suffix * ints[j];
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
