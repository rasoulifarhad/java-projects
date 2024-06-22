package com.farhad.example.tic_tac_toe;

public class TicTacToe {


    private static final String NO_WINNER = "No winner";

    private static final String RESULT_DRAW = "The result is draw";

    private static final int SIZE = 3;

    private Character[][] board  = {
        {'\0', '\0', '\0'},
        {'\0', '\0', '\0'},
        {'\0', '\0', '\0'}
    };

    private char lastPlayer = '\0';

    private void setBox(int x, int y, char lastPlayer) {
        if(board[x -1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x -1][y - 1] = lastPlayer;
        }
    }

    private void checkAxis(int axis) {
        if(axis < 1 ||  axis > 3) {
            throw new RuntimeException("X is outside board.");
        }
    }

   public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        if(isWin(x, y)){
            return lastPlayer + " is the winner";
        } else if(isDraw()) {
            return RESULT_DRAW;
        }
        return NO_WINNER;
    }

    private boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * SIZE;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for (int i = 0; i < SIZE; i++) {
            vertical += board[x - 1][i];
            horizontal += board[i][y - 1];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
            if(horizontal == playerTotal 
                || vertical == playerTotal 
                || diagonal1 == playerTotal 
                || diagonal2 == playerTotal) {
                return true;
            }
        }
        return false;
    }

    public char nextPlayer() {
        if(lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

}
