package com.farhad.example.codekata.theatrical_players_refactoring_kata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.approvaltests.Approvals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StatementPrinterTest {

    @Test
    public void exampleStatement() {

        Map<String, Play> plays = new HashMap<String, Play>() {
            {
                put("hamlet", new Play("Hamlet", "tragedy"));
                put("as-like", new Play("As You Like It", "comedy"));
                put("othello", new Play("Othello", "tragedy"));
            }
        };
        List<Performance> performances =  Arrays.asList(
            new Performance("hamlet", 55),
            new Performance("as-like", 35),
            new Performance("othello", 40));
        Invoice invoice = new Invoice("BigCo", performances);
        StatementPrinter statementPrinter = new StatementPrinter();
        String result = statementPrinter.print(invoice, plays);
        Approvals.verify(result);
    }

    @Test
    public void statementWithNewPlayTypes() {
        Map<String, Play> plays = new HashMap<String, Play>() {
            {
                put( "henry-v",  new Play("Henry V", "history"));
                put("as-like", new Play("As You Like It", "pastoral"));
            }
        };
        List<Performance> performances =  Arrays.asList(
            new Performance("henry-v", 53),
            new Performance("as-like", 55));
        Invoice invoice = new Invoice("BigCo", performances);
        StatementPrinter statementPrinter = new StatementPrinter();
        Assertions.assertThrows(Error.class, () -> {
            statementPrinter.print(invoice, plays);
        });
    }

}
