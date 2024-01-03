package com.farhad.example.functional_interface.string_manipulation;

import java.util.stream.Stream;

public class StringChainingFunctional {


	// public static <R> R transform(Function<? super String, ? extends R> f) {
	// }
	
	public static String cleanUserName(String username) {
		return Stream.of(username)
				.map(String::trim)
				.map(String::toLowerCase)
				.map(n -> n.replaceAll("-", ""))
				.findFirst()
				.orElse("");

	}

	public static void main(String[] args) {
		System.out.println(
				cleanUserName("  JoHN-dOe  "));
			
	}
}
