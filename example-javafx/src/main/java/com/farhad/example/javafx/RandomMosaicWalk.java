package com.farhad.example.javafx;

public class RandomMosaicWalk {

    static int currentRow;
    static int currentColumn;

    public static void main(String[] args) {
        Mosaic.open(16, 20, 25, 25);
        fillWithRandomColors();
        currentRow = 8;
        currentColumn = 10;
        while (true) {
            changeToRandomColor(currentRow, currentColumn);
            randomMove();
            Mosaic.delay(100);
        }
    }

    private static void randomMove() {
        int direction = (int)(4 * Math.random());
        switch (direction) {
            case 0:
                currentRow = (currentRow - 1 < 0) ? 15 : currentRow - 1;
                break;
            case 1:
                currentColumn = (currentColumn + 1) % 20;
                break;
            case 2:
                currentRow = (currentRow + 1) % 16;
                break;
            case 3:
                currentColumn = (currentColumn - 1 < 0) ? 19 : currentColumn - 1;
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
        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 20; col++) {
                changeToRandomColor(row, col);
            }
                
        }
    }
}
