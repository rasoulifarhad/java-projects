package com.farhad.example.codekata.leader_board_kata;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Driver {

    private final String name;
    private final String country;
}
