package com.farhad.example.tic_tac_toe_v2.mongo;

import lombok.Value;

@Value
public class TicTacToeBean {

    private int turn;
    private int x;
    private int y;
    private char player;

    public TicTacToeBean(int turn, int x, int y, char player) {
        this.turn = turn;
        this.x = x;
        this.y = y;
        this.player = player;
    }


}
