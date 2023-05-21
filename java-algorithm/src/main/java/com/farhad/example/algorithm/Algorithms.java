package com.farhad.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithms {
    
    /**
     * The Two-Pointers Technique
     * 
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric 
     * characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     * 
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     */
    public static boolean isPalindrome(String s) { 

        if ( s == null || s.isEmpty() ) {
            return false;
        }

        if ( s.length() == 1 ) {
            return true ;
        }

        int start = 0;
        int end = s.length() -1 ;

        s = s.toLowerCase();

        while( start < end ) {
            char a = s.charAt(start);
            char b = s.charAt(end);

            if ( !Character.isLetterOrDigit(a) ) {
                start++ ;
                continue;
            }

            if ( !Character.isLetterOrDigit(b) ) {
                end--; ;
                continue;
            }

            if ( a != b ) {
                return false;
            }

            start++ ;
            end--;
        }
        return true ;
    }

    /**
     * The Two-Pointers Technique
     * 
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they 
     * add up to a specific target number. 
     * 
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
     */
    public static int[] twoSum( int[] numbers, int target ) {

        int [] rez = new int [2];

        int start = 0 ;
        int end = numbers.length -1 ;

        while ( start < end ) {
            int a = numbers[start] ;
            int b = numbers[end];

            if ( a + b == target ) {
                rez[0] = start + 1 ;
                rez[1] = end + 1 ;
                return rez;
            } else if ( a + b > target ) {
                end--;
            } else {
                start++ ;
            }
        }
        return rez;
    }

    /**
     * The Two-Pointers Technique
     * 
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
     * and nums[i] + nums[j] + nums[k] == 0.
     * 
     * Notice that the solution set must not contain duplicate triplets.
     * 
     * First of all, we need to sort the array. Then I want to iterate over the array and get element one on index i. 
     * 
     * Then we can prepare two elements. So, the second (start pointer) element will be on position i + 1, and the third (end pointer) 
     * will be on position length - 1. Then based on the sum, we can move start/end pointers. 
     */
    public static List<List<Integer>> threeSum(int [] numbers) {

        if ( numbers.length < 3 ) {
            return new ArrayList<>();
        }

        Arrays.sort(numbers);

        List<List<Integer>> rez = new ArrayList<>();

        for(int i = 0 ; i < numbers.length; i++) {
            if ( i > 0 && numbers[i] == numbers[i-1] ) {
                continue;
            }
            int start = i+1 ;
            int end = numbers.length -1 ;

            while (start < end) {
                int threeSum = numbers[i] + numbers[start] + numbers[end];

                if ( threeSum == 0 ) {
                    rez.add(Arrays.asList(numbers[i], numbers[start], numbers[end]));

                    while (start < end && numbers[start] == numbers[start + 1]) {
                        start++;
                        
                    }
                    while (start < end && numbers[end -1] == numbers[end]) {
                        end--;
                    }
                    start++;
                    end--;

                } else if ( threeSum > 0 ){
                    end--;
                } else {
                    start ++;
                }
            }
        }
        return rez;
    }
}
