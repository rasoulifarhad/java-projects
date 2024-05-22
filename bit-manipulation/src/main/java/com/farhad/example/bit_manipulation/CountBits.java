package com.farhad.example.bit_manipulation;

public class CountBits {

    public int countBitsLib(int num) {
        return Integer.bitCount(num);
    }

    public int countBitsBW(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1);
            num = num >> 1;
        }

        return count;
    }

    public int countBitsBWBest(int num) {
        int count = 0;
        while (num > 0) {
            num = num & (num - 1);
            count++;
        }

        return count;
    }

}
