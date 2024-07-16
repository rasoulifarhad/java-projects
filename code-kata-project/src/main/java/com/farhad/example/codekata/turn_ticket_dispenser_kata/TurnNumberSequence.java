package com.farhad.example.codekata.turn_ticket_dispenser_kata;

public class TurnNumberSequence {

    private static int _turnNumber = 0;

    public static int getNextTurnNumber() {
        return _turnNumber++;
    }
}
