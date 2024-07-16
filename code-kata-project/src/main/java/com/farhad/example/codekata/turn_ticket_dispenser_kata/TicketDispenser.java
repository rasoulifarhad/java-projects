package com.farhad.example.codekata.turn_ticket_dispenser_kata;

public class TicketDispenser {

    public TurnTicket getTurnTicket() {

        int newTurnNumber = TurnNumberSequence.getNextTurnNumber();
        TurnTicket turnTicket = new TurnTicket(newTurnNumber);
        return turnTicket;
    }
}
