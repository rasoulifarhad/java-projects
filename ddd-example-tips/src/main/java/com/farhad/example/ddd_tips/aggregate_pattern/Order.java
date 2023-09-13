package com.farhad.example.ddd_tips.aggregate_pattern;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class Order {
	private String id;
	private Instant date;
	private List<OrderPosition> orderPositions;
	private Long version; // optimistic locking!

	// stuff

	public void addPosition(Product product, BigDecimal quantity) {
		if (hasMaxPosition()) {
			throw new TooManyPositionsException(id);
		}
		if (valueTooHigh(product.getrPrice().times(quantity)	)) {
			throw new ValueTooHighException(id);
		}
	}

	private boolean valueTooHigh(Money times) {
		return false;
	}

	private boolean hasMaxPosition() {
		return false;
	}
}
