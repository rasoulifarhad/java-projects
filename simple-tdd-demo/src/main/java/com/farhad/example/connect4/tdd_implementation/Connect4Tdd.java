package com.farhad.example.connect4.tdd_implementation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Connect4Tdd {

    private static final String RED = "R";
    private static final String GREEN = "G";
    private static final String EMPTY = " ";
    private static final int COLUMNS = 7;
    private static final int ROWS = 6;
    private String currentPlayer = RED;

    private String[][] board = new String[ROWS][COLUMNS];

    
    public Connect4Tdd() {
        for (String[] row : board) {
            Arrays.fill(row, EMPTY);
        }
    }

    public int getNumberOfDiscs() {
        return IntStream.range(0, COLUMNS)
                .map(this::getNumberOfDiscsInColumn)
                .sum();
    }

    private int getNumberOfDiscsInColumn(int column){
        return (int)IntStream.range(0, ROWS)
                    .filter(row -> !EMPTY.equals(board[row][column]))
                    .count();
    }

    public int putDiscInColumn(int column) {
        checkColumn(column);
        int row = getNumberOfDiscsInColumn(column);
        checkPositionToInsert(row, column);
        board[row][column] = currentPlayer;
        switchPlayer();
        return row;
    }

    private void switchPlayer() {
        currentPlayer = RED.equals(currentPlayer) ? GREEN : RED;
    }

    private void checkPositionToInsert(int row, int column) {
        if(row == ROWS) {
            throw new RuntimeException("No more room in column " + column);
        }
    }

    private void checkColumn(int column) {
        if (column < 0 || column >= COLUMNS) {
            throw new RuntimeException("Invalid column " + column);
        }
    }

    public Object getCurrentPlayer() {
        return currentPlayer;
    }

}
