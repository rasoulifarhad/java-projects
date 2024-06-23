package com.farhad.example.tic_tac_toe_v2;

import com.farhad.example.tic_tac_toe_v2.mongo.TicTacToeBean;
import com.farhad.example.tic_tac_toe_v2.mongo.TicTacToeCollection;

import lombok.AccessLevel;
import lombok.Getter;

public class TicTacToe {


    private static final String NO_WINNER = "No winner";

    private static final String RESULT_DRAW = "The result is draw";

    private static final int SIZE = 3;

    @Getter(value = AccessLevel.PROTECTED)
    private TicTacToeCollection ticTacToeCollection;

    private int turn = 0;

    private Character[][] board  = {
        {'\0', '\0', '\0'},
        {'\0', '\0', '\0'},
        {'\0', '\0', '\0'}
    };

    private char lastPlayer = '\0';

    public TicTacToe() {
        this(new TicTacToeCollection());
    }

    protected TicTacToe(TicTacToeCollection ticTacToeCollection) {
        this.ticTacToeCollection = ticTacToeCollection;
        ticTacToeCollection.drop();
    }

   public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(new TicTacToeBean(++turn, x, y, lastPlayer));
        if(isWin(x, y)){
            return lastPlayer + " is the winner";
        } else if(isDraw()) {
            return RESULT_DRAW;
        }
        return NO_WINNER;
    }

    private void checkAxis(int axis) {
        if(axis < 1 ||  axis > 3) {
            throw new RuntimeException("X is outside board.");
        }
    }

    private void setBox(TicTacToeBean move) {
        if(board[move.getX() -1][move.getY() - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[move.getX() -1][move.getY() - 1] = move.getPlayer();        
            if(!getTicTacToeCollection().saveMove(move)){
                throw new RuntimeException("Saving to db failed");
            }
        }
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
