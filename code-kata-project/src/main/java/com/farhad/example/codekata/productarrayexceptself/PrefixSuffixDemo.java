package com.farhad.example.codekata.productarrayexceptself;

import java.util.StringJoiner;

public class PrefixSuffixDemo {
    
    // Given [x1, x2, x3, Y, x4, x5]
    // When we want to calc value for index 3 ( Y ) 
    // Then  Prefix: ([x1, x2, x3]) (Y) Suffix: ([x4, x5])
    // value at index 2 (x1 * x2 * x3) must pruduct to value at index 4 (x5 * x4)
    static class Solution{

        public int [] productArray(int [] ints) {

            int size = ints.length;
            int [] res = new int[size];
            int [] prefix = new int[size];
            int [] suffix = new int[size];

            int temp = 1;
            for (int i = 0; i < size; i++) {            
                prefix[i] = temp ;
                temp = temp * ints[i];
            }

            temp = 1;
            for (int j = size -1 ; j >= 0; j--) {
                suffix[j] = temp;
                temp = temp * ints[j];
            }

            for (int i = 0; i < size; i++) {
                res[i] = prefix[i] * suffix[i];
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
