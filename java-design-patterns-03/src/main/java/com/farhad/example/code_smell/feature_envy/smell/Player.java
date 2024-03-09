package com.farhad.example.code_smell.feature_envy.smell;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {

	private final String name;
	private final int goalsScored;
}
