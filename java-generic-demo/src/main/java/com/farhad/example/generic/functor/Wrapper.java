package com.farhad.example.generic.functor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Wrapper<A> {

	@Getter
	private final A value;
}
