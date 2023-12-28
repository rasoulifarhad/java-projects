package com.farhad.example.functional_interface.string_manipulation;

import java.util.stream.Collectors;

public class RemoveCharFunctional {

	public static String removeChar(String str, char c) {

		return str.chars()
				.filter(ch -> ch != c)
				.mapToObj(ch -> String.valueOf((char) ch))
				.collect(Collectors.joining());
	}
	
	public static void main(String[] args) {
		String str = "abcdefghijk";
		char ch = 'i';
		String result = removeChar(str, ch);
		System.out.println(result);
	}

}
