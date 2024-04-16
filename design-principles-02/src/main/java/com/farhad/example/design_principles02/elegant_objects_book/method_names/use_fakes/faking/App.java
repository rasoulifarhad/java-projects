package com.farhad.example.design_principles02.elegant_objects_book.method_names.use_fakes.faking;

public class App {

	public static void main(String[] args) {
		{
			Exchange exchange = new Exchange.Fake();
			
			Cash dollar = new Cash(exchange, 500);
			Cash euro = dollar.in("EUR");
			assert "¢1500".equals(euro.toString());

		}
	}
}
