package com.farhad.example.design_principles02.elegant_objects_book.method_names.use_fakes.mocking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AppTest {

	@Test
	public void testCash() {
		Exchange exchange = Mockito.mock(Exchange.class);
		Mockito.doReturn(3)
			.when(exchange)
			.rate("USD", "EUR");
		
		Cash dollar = new Cash(exchange, 500);
		Cash euro = dollar.in("EUR");
		assertThat(euro.toString()).isEqualTo("¢1500");

	}
}
