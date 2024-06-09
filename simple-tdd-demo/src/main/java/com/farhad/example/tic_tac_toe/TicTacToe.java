package com.farhad.example.tic_tac_toe;

public class TicTacToe {


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
        if(isWin()){
            return lastPlayer + " is the winner";
        }
        return "No winner";
    }

private boolean isWin() {
    int playerTotal = lastPlayer * SIZE;
    for (int i = 0; i < SIZE; i++) {
        if(board[0][i] + board[1][i] + board[2][i] == playerTotal) {
            return true; 
        } 
        if(board[i][0] + board[i][1] + board[i][2] == playerTotal) {
            return true;
        }
        if(board[0][0] + board[1][1] + board[2][2] == playerTotal) {
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
