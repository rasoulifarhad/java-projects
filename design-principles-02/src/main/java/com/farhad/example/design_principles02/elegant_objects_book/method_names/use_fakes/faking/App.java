package com.farhad.example.design_principles02.elegant_objects_book.method_names.use_fakes.faking;

import org.mockito.Mockito;

public class App {

	public static void main(String[] args) {
		{
			Exchange exchange = Mockito.mock(Exchange.class);
			Mockito.doReturn(3)
				.when(exchange)
				.rate("USD", "EUR");
			
			Cash dollar = new Cash(exchange, 500);
			Cash euro = dollar.in("EUR");
			assert "¢1500".equals(euro.toString());

		}
	}
}
