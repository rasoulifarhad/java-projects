package com.farhad.example.design_principles02.elegant_objects_book.method_names.use_fakes.faking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AppTest {

	@Test
	public void testCash() {

		Exchange exchange = new Exchange.Fake();

		Cash dollar = new Cash(exchange, 500);
		Cash euro = dollar.in("EUR");
		assertThat(euro.toString()).isEqualTo("¢1500");

	}
}
