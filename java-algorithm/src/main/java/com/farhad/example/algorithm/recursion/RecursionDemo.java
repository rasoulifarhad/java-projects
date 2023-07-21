package com.farhad.example.algorithm.recursion;

import java.util.StringJoiner;
import java.util.stream.IntStream;

public class RecursionDemo {
    

    public int sumInts(int x, int y) {
        if ( y == 0) {
            return x;
        } else {
            return 1 + sumInts(x, y -1);
        }
    }

    public int productInts(int x, int y) {
        if (y == 0) {
            return 0;
        } else {
            // return x + productInts(x, y - 1 );
            return sumInts(x, productInts(x, y - 1 ));
        }
    }

    public int powerInts(int x, int y) {
        if (y == 0) {
            return 1;
        } else {
            // return x * powerInts(x, y - 1);
            return productInts(x, powerInts(x, y - 1));
        }
    }

    public int foctorial(int n) {
        return n == 0 ? 1 : n * foctorial(n - 1 );
    }

    public void reverseArray(int[] arr, int leftPos, int rightPos) {
        if (leftPos >= rightPos){
            return;
        } else {
            swap(arr, leftPos, rightPos);
            reverseArray(arr, leftPos + 1 , rightPos -1 );
        }
    }

    private void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // greatest common divisor
    // Brute Force Approach 
    public int gcd(int m, int n) {
        int minValue = Math.min(m, n);
        if (m % minValue == 0 && m % minValue == 0) {
            return minValue;
        }
        for (int i = minValue / 2; i > 1 ; i--) {
            if(m % i == 0 && n % i == 0) {
                return i;
            }        
        }
        return 1;
    }

    public int gcdRecursionWithDifference(int m, int n) {
        if (m == 0) {
            return n;
        }
        if(n == 0) {
            return m;
        }
        if (m == n) {
            return m;
        }
        if (m > n ) {
            return gcdRecursionWithDifference(m-n , n);
        }
        return gcdRecursionWithDifference(m, n - m);
        
    }

    // There are special names for each number in a division:
    // dividend ÷ divisor = quotient with  remainder
    public int gcdRecursionWithEuclidean(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcdRecursionWithEuclidean(n, m % n);
        }

    }

    public static void main(String[] args) {
        RecursionDemo demo = new RecursionDemo();

        System.out.println(demo.sumInts(10, 6));
        System.out.println(demo.productInts(3, 4));
        System.out.println(demo.powerInts(3, 2));
        System.out.println(demo.foctorial(3));

        int [] ints = new int [] {1, 2, 3, 4, 5};
        demo.reverseArray(ints, 0, ints.length -1 );
        StringJoiner joiner = new StringJoiner(" ","[ "," ]");
        IntStream.of(ints).forEach(i -> joiner.add(String.valueOf(i)) );
        System.out.println(joiner.toString());

        System.out.println(demo.gcd(48, 18));
        System.out.println(demo.gcdRecursionWithDifference(48, 18));
        System.out.println(demo.gcdRecursionWithEuclidean(48, 18));
    }
}
