package com.farhad.example.ddd_tips.jmolecules_order_demo.domain.model.orders;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.farhad.example.ddd_tips.jmolecules_order_demo.domain.model.customers.Customer;
import com.farhad.example.ddd_tips.jmolecules_order_demo.domain.model.customers.Customer.CustomerId;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Entity
@Table(name = "orders")
@NoArgsConstructor(force = true)
@EqualsAndHashCode(of = "id")
@Getter
public class Order {
	
	@EmbeddedId
	private final OrderId id;

	@OneToMany(cascade = CascadeType.ALL)
	private List<LineItem> lineItems;
	private Customer.CustomerId customerId;

	public Order(CustomerId customerId) {
		this.id = OrderId.of(UUID.randomUUID());
		this.customerId = customerId;
	}

	@Value
	@RequiredArgsConstructor(staticName = "of")
	@NoArgsConstructor(force = true)
	public static class OrderId {

		private final UUID id;

	}
}
