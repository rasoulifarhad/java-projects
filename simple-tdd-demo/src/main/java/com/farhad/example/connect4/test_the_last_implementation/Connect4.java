package com.farhad.example.connect4.test_the_last_implementation;

import java.util.Arrays;

public class Connect4 {

    private static final int COLUMNS = 7;
    private static final int ROWS = 6;

    private Color[][] board = new Color[COLUMNS][ROWS];

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

    
}
