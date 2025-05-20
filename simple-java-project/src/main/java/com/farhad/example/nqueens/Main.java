package com.farhad.example.nqueens;

public class Main {

    public static void main(String[] args) {
        int nQueen = 8;
        int row = 0;
        int col = 0;
        boolean[][] board = new boolean[nQueen][nQueen];
        do {
            while (row < nQueen && col < nQueen) {
                if(isSafe()) {
                    advanceNextQueen();
                } else {
                    moveQueen();
                }
            }
            if(row>= nQueen) {
                retreat();
            }
        } while (col < nQueen && col >= 0) ;

        if(col == nQueen) {
            // ok
        }
    }

    private static void moveQueen() {
    }

    private static void retreat() {
    }

    private static void advanceNextQueen() {
    }

    private static boolean isSafe() {
        return false;
    }
}
