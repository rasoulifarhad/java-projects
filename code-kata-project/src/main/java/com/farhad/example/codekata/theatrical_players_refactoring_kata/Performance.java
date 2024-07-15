package com.farhad.example.codekata.theatrical_players_refactoring_kata;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Performance {

    private final String playId;
    private final int audience;
}
