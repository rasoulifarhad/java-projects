package com.farhad.example.connect4.test_the_last_implementation;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Connect4 {

    private static final int COLUMNS = 7;
    private static final int ROWS = 6;
    private static final String DELIMITER = "|";
    public static final int DISCS_FOR_WIN = 4;

    private Color[][] board = new Color[COLUMNS][ROWS];

    private Color currentPlayer = Color.RED;
    private Color winner;


    public enum Color {
        RED('R'), GREEN('G'), EMPTY(' ');

        private final char value;

        Color(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public Connect4() {
        for (Color[] column : board) {
            Arrays.fill(column, Color.EMPTY);
        }
    }

    public void printBoard() {
        for (int row = ROWS -1; row >= 0; --row) {
            StringJoiner stringJoiner = new StringJoiner(DELIMITER, DELIMITER, DELIMITER);
            for (int col = 0; col < COLUMNS; col++) {
                stringJoiner.add(board[col][row].toString());
            }
            System.out.println(stringJoiner.toString());
        }
    }

    public boolean isFinished() {
        if(winner != null) {
            return true;
        }
        int numOfDiscs = 0;
        for (int col = 0; col < COLUMNS; col++) {
            numOfDiscs += getNumberOfDiscsInColumn(col);
        }
        if(numOfDiscs >= ROWS * COLUMNS) {
            System.out.println("It is a draw.");
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        currentPlayer =  Color.RED == currentPlayer ? Color.GREEN : Color.RED;
        System.out.println("Current turn: " + currentPlayer);
    }

    private void checkWinCondition(int col, int row) {
        Pattern winPattern = Pattern.compile(String.format(".%s{%d}.*", currentPlayer, DISCS_FOR_WIN));
    }

    public void putDisc(int column) {
        if(column > 0 && column <= COLUMNS) {
            int numberOfDiscs = getNumberOfDiscsInColumn(column - 1);
            if(numberOfDiscs < ROWS) {
                board[column - 1][numberOfDiscs] = currentPlayer;
                printBoard();
                checkWinCondition(column - 1, numberOfDiscs);
                switchPlayer();
            } else {
                System.out.println(numberOfDiscs);
                System.out.println("There is no room for a new disc in this column");
                printBoard();
            }
        } else {
            System.out.println("Column out of bounds");
            printBoard();
        }
    }

    private int getNumberOfDiscsInColumn(int column) {
        int row;
        for (row = 0; row < ROWS; row++) {
            if (Color.EMPTY == board[column][row]) {
                return row;
            }

        }
        return row;
    }

    public static void main(String[] args) {
        System.out.println(String.format(".%s{%d}.*", "R", 4));
    }
}
