package com.farhad.example.nqueens;

public class Main {
        static int row = 0;
        static int col = 0;

    public static void main(String[] args) {
        int nQueen = 8;
        int[] board = new int[nQueen];
        do {
            while (row < nQueen && col < nQueen) {
                if(isSafe(board)) {
                    advanceNextQueen(board);
                } else {
                    moveQueen();
                }
            }
            if(row>= nQueen) {
                retreat(board);
            }
        } while (col < nQueen && col >= 0) ;

        if(col == nQueen) {
            printBoard(board);
        } else {
            System.out.println("Error");
        }
    }

    private static void printBoard(int[] board) {
        // System.out.print(" ");
        System.out.print("     ");
        for (int i = 1; i <= board.length; i++) {
            System.out.printf(" %s  " , i);
        }
        System.out.println();
        System.out.print("   ");
        line(board);
        for (int i = 0; i < board.length; i++) {
            System.out.printf(" %s  " , i + 1);
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                if(board[j] == i ) {
                    System.out.print(" X |");
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println();
            System.out.print("   ");
            line(board);
        }
    }

    private static void line(int[] board) {
        System.out.print(" ");
        for (int i = 0; i < board.length; i++) {
            System.out.print("----");
        }
        System.out.println("-");
    }
    private static void moveQueen() {
        row++;
    }

    private static void retreat(int[] board) {
        col--;
        row = board[col] + 1;
    }

    private static void advanceNextQueen(int[] board) {
        board[col] = row;
        col++;
        row = 0;
    }

    private static boolean isSafe(int[] board) {
        boolean isSafe = true;
        for (int i = 0; i < col; i++) {
            if (testDownDiagonal(board, i) ||
                testUpDiagonal(board, i) ||
                testRow(board, i)) {
                    isSafe = false;
            }
        }
        return isSafe;
    }

    private static boolean testRow(int[] board, int i) {
        return board[i] == row;
    }

    private static boolean testUpDiagonal(int[] board, int i) {
        return (board[i] - i ) == (row - col);
    }

    private static boolean testDownDiagonal(int[] board, int i) {
        return (board[i] + i ) == (row + col);
    }
}
