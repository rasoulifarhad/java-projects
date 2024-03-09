package com.farhad.example.code_smell.feature_envy.better;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {

	private final String name;
	private final int goalsScored;
}
