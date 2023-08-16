package com.farhad.example.codekata.containsduplicate;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class HashSetDemo02 {
    
    static class Solution {

        public boolean containsDuplicate(int [] ints) {

            Set<Integer> dups = new HashSet<>();
            for (int i = 0; i < ints.length; i++) {
                if (dups.contains(ints[i])) {
                    return true;
                } 
                dups.add(ints[i]);
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
