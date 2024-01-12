package com.farhad.example.generic.monad;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Wrapper<A> {

	private final A value;
}
