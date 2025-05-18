package com.farhad.example.javafx;

public class RandomMosaicWalk {

    final static int ROWS = 16;
    final static int COLUMNS = 20;
    final static int SQUARE_SIZE = 35;

    static int currentRow;
    static int currentColumn;

    public static void main(String[] args) {
        Mosaic.open(ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE);
        fillWithRandomColors();
        currentRow = ROWS / 2;
        currentColumn = COLUMNS / 2;
        while (true) {
            changeToRandomColor(currentRow, currentColumn);
            randomMove();
            Mosaic.delay(5);
        }
    }

    private static void randomMove() {
        int direction = (int)(4 * Math.random());
        switch (direction) {
            case 0:
                currentRow = (currentRow - 1 < 0) ? (ROWS - 1) : currentRow - 1;
                break;
            case 1:
                currentColumn = (currentColumn + 1) % COLUMNS;
                break;
            case 2:
                currentRow = (currentRow + 1) % ROWS;
                break;
            case 3:
                currentColumn = (currentColumn - 1 < 0) ? (COLUMNS - 1) : currentColumn - 1;
                break;
        }
    }

    private static void changeToRandomColor(int rowNum, int colNum) {
        int red = (int) (256 * Math.random());
        int green = (int) (256 * Math.random());
        int blue = (int) (256 * Math.random());
        Mosaic.setColor(rowNum, colNum, red, green, blue);
    }

    private static void fillWithRandomColors() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                changeToRandomColor(row, col);
            }
                
        }
    }
}
