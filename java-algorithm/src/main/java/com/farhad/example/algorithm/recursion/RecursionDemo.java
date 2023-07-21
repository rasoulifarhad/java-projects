package com.farhad.example.algorithm.recursion;

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

    public static void main(String[] args) {
        RecursionDemo demo = new RecursionDemo();

        System.out.println(demo.sumInts(10, 6));
        System.out.println(demo.productInts(3, 4));
        System.out.println(demo.powerInts(3, 2));
    }
}
