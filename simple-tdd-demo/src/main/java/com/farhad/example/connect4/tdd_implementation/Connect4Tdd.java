package com.farhad.example.connect4.tdd_implementation;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Connect4Tdd {

    private static final int DISC_TO_WIN = 4;
    private static final String DELIMITER = "|";

    private static final String RED = "R";
    private static final String GREEN = "G";
    private static final String EMPTY = " ";
    private static final int COLUMNS = 7;
    private static final int ROWS = 6;
    private String currentPlayer = RED;

    private String[][] board = new String[ROWS][COLUMNS];
    private PrintStream outputChannel;
    private String winner = "";
    
    public Connect4Tdd(PrintStream out) {
        this.outputChannel = out;
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
        printBoard();
        checkWinner(row, column);
        switchPlayer();
        return row;
    }

    private void checkWinner(int row, int column) {
        if(winner.isEmpty()) {
            String color = board[row][column];
            String vertical = IntStream.range(0, ROWS)
                .mapToObj(r -> board[r][column])
                .reduce(String::concat)
                .get();
            Pattern winPattern = Pattern.compile(".*" + color + "{" + DISC_TO_WIN +  "}.*");
            if(winPattern.matcher(vertical).matches()) {
                winner = color;
            }
        }
        if (winner.isEmpty()) {
            String color = board[row][column];
            String horizontal = IntStream.range(0, COLUMNS)
                .mapToObj(c -> board[row][c])
                .reduce(String::concat)
                .get();
            Pattern winPattern = Pattern.compile(".*" + color + "{" + DISC_TO_WIN +  "}.*");
            if(winPattern.matcher(horizontal).matches()) {
                winner = color;
            }
        }
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
        outputChannel.printf("Player %s turn%n", currentPlayer);
        return currentPlayer;
    }
    
    private void printBoard() {
        for (int row = ROWS - 1; row >= 0; row--) {
            StringJoiner stringJoiner = new StringJoiner(DELIMITER,DELIMITER,DELIMITER);
            Stream.of(board[row])
                .forEachOrdered(stringJoiner::add);
            outputChannel.println(stringJoiner.toString());
        }
    }

    public boolean isFinished() {
        return getNumberOfDiscs() == ROWS * COLUMNS;
    }

    public String getWinner() {
        return winner;
    }
}
