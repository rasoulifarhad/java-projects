package com.farhad.example.codekata.turn_ticket_dispenser_kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TicketDispenserTest {

    @Test
    void foo() {
        TicketDispenser dispenser = new TicketDispenser();
        TurnTicket ticket = dispenser.getTurnTicket();
        assertEquals(-1, ticket.getTurnNumber());
    }    
}
