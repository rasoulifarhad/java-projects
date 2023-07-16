package com.farhad.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.LongStream;

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

    // Given a List<Integer> value, for example, {1, 4, 9}, construct a
    // List<List<Integer>> value whose members are all the subsets of {1, 4, 9}—in any order. The
    // subsets of {1, 4, 9} are {1, 4 ,9}, {1, 4}, {1, 9}, {4, 9}, {1}, {4}, {9}, and {}.
    public static List<List<Integer>> allSubsets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());
        List<List<Integer>> subans = allSubsets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);
    }

    private static List<List<Integer>> concat(List<List<Integer>> ll1, List<List<Integer>>  ll2 ) {
        List<List<Integer>> result = new ArrayList<>(ll1);
        result.addAll(ll2);
        // for (List<Integer> list : ll2) {
        //     result.add(list);
        // }
        return result;
    }

    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subans ) {
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> sub : subans) {
            List<Integer> list =  new ArrayList<>();
            list.add(first);
            list.addAll(sub);
            res.add(list);
        }
        return res;
    }

    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int factorialRecursive(int n) {
        return n == 1 ? 1 : n * factorialIterative(n -1 );
    }

    public static long factorialStreams(long n) {
        return 
            LongStream.rangeClosed(1, n)
                      .reduce(1, (left, right) -> left * right);  
    }

    public static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);

    }

    // The function factorialHelper is tail recursive because the recursive call is the last thing 
    // that happens in the function.
    //
    // This form of recursion is useful because instead of storing each intermediate result of the
    // recursion onto different stack frames, the compiler can decide to reuse a single stack frame.
    // 
    // Indeed, in the definition of factorialHelper, the intermediate results (the partial results of the
    //  factorial) are passed directly as arguments to the function. There’s no need to keep track of the
    // intermediate result of each recursive call on a separate stack frame—it’s accessible directly
    // through the argument of the function.
    // 
    private static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n -1 );
    }
}
