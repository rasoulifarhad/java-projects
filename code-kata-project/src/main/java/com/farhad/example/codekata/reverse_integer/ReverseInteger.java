package com.farhad.example.codekata.reverse_integer;

public class ReverseInteger {

    public int reverse(int number) {
        int reversed = 0;
        int origin = number;

        while(origin != 0) {
            reversed = (reversed * 10) + ( origin % 10);
            origin /= 10;
        }
        return reversed;

    }

    public static void main(String[] args) {
        
        ReverseInteger r = new ReverseInteger();
        test(-321, r.reverse(-123));
        test(321, r.reverse(123));
        test(321, r.reverse(123));


    }



    public static void test(int expected, int actual) {
        if(expected != actual) {
            System.out.println("expected: " + expected + " but got: " + actual);
        } else {
            System.out.println("Passed");
        }
    }

}
