package com.farhad.example.codekata.containsduplicate;

import java.util.Arrays;
import java.util.StringJoiner;

public class WithSortDemo {
    
    static class Solution {

        public boolean containsDuplicate(int [] ints) {
            Arrays.sort(ints);
            for (int i = 0; i < ints.length - 1; i++) {
                if ( ints[i] == ints[i + 1] ) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        
        Solution solution = new Solution();

        int [] ints = {1,2,3,1};
        System.out.println(toString(ints) + " -> " + solution.containsDuplicate(ints));


        ints = new int[] {1,2,3,4};
        System.out.println(toString(ints) + " -> " + solution.containsDuplicate(ints));

        ints = new int [] {1,1,1,3,3,4,3,2,4,2}; 
        System.out.println(toString(ints) + " -> " + solution.containsDuplicate(ints));

    }

    private static String toString(int [] ints) {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (int i : ints) {
            joiner.add(Integer.toString(i));
        }
        return joiner.toString();
    }

}
