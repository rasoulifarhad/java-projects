package com.farhad.example.dispatch.greeter;

// import static org.hamcrest.CoreMatchers.containsString;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;;

public class GreeterTest {
	
	private Greeter greeter = new Greeter();

	@Test
	public void greeterSaysHello() {
		assertThat(greeter.sayHello()).contains("Hello");
	}

}
