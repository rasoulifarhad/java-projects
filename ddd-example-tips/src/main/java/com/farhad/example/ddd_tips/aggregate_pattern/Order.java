package com.farhad.example.ddd_tips.aggregate_pattern;

import java.time.Instant;
import java.util.List;

public class Order {
	private String id;
	private Instant date;
	private List<OrderPosition> orderPositions;

	// stuff
}
