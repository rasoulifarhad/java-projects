package com.farhad.example.connect4.test_the_last_implementation;

import java.util.Arrays;

public class Connect4 {

    private static final int COLUMNS = 7;
    private static final int ROWS = 6;

    private Color[][] board = new Color[COLUMNS][ROWS];

    private Color currentPlayer = Color.RED;

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

    public void switchPlayer() {
        currentPlayer =  Color.RED == currentPlayer ? Color.GREEN : Color.RED;
    }

    public void putDisc(int column) {
        if(column > 0 && column <= COLUMNS) {
            int numberOfDiscs = getNumberOfDiscsInColumn(column - 1);
            if(numberOfDiscs < ROWS) {
                board[column - 1][numberOfDiscs] = currentPlayer;
                switchPlayer();
            }
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
    
}
