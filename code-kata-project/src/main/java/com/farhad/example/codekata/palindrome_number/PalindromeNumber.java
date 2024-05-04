package com.farhad.example.codekata.palindrome_number;

public class PalindromeNumber {

    public boolean satisfiedBy(int number) {
        return number ==  reverse(number);
    }

    private int reverse(int number) {
        int reversed = 0;
        int origin = number;

        while(origin != 0) {
            reversed = (reversed * 10) + ( origin % 10);
            origin /= 10;
        }
        return reversed;

    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();

        System.out.println(p.satisfiedBy(121));
        System.out.println(p.satisfiedBy(10));
        System.out.println(p.satisfiedBy(12321));
        System.out.println(p.satisfiedBy(-12321));

    }


}
