package com.farhad.example.codekata.containsduplicate;

import java.util.StringJoiner;

public class BruteForceDemo {
    
    static class Solution {

        public boolean containsDuplicate(int [] ints) {
            for (int i = 0; i < ints.length; i++) {
                int subject = ints[i];
                for (int j = ints.length - 1 ; j > i ; j--) {
                    if( subject == ints[j] ) {
                        return true;
                    }
                }
            }
            return false;
        }
    
    public boolean containsDuplicate02(int [] ints) {
            for (int i = 0; i < ints.length; i++) {
                int subject = ints[i];
                for (int j = i + 1 ; j < ints.length ; j++) {
                    if( subject == ints[j] ) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        
        Solution solution = new Solution();

        int [] ints = {1,2,3,1};
        System.out.println(toString(ints) + " -> " + solution.containsDuplicate(ints));
        System.out.println(toString(ints) + " -> " + solution.containsDuplicate02(ints));


        ints = new int[] {1,2,3,4};
        System.out.println(toString(ints) + " -> " + solution.containsDuplicate(ints));
        System.out.println(toString(ints) + " -> " + solution.containsDuplicate02(ints));

        ints = new int [] {1,1,1,3,3,4,3,2,4,2}; 
        System.out.println(toString(ints) + " -> " + solution.containsDuplicate(ints));
        System.out.println(toString(ints) + " -> " + solution.containsDuplicate02(ints));

    }

    private static String toString(int [] ints) {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (int i : ints) {
            joiner.add(Integer.toString(i));
        }
        return joiner.toString();
    }
}
