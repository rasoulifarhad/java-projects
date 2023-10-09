package com.farhad.example.producer_consumer;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Event {
	
	private final int number;
	private final String source;
}
