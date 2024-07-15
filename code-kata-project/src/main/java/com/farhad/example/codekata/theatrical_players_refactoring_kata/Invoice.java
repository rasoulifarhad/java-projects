package com.farhad.example.codekata.theatrical_players_refactoring_kata;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Invoice {

    private final String customer;
    private final List<Performance> performances;
}
