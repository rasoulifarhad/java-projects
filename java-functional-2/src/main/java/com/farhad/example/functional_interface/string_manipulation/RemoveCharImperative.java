package com.farhad.example.functional_interface.string_manipulation;

public class RemoveCharImperative {


	public static String removeChar(String input, char c) {
		StringBuilder sb = new StringBuilder();
		char[] charArray = input.toCharArray();

		for (char ch : charArray) {
			if (ch != c) {
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "abcdefghijk";
		char ch = 'i';
		String result = removeChar(str, ch);
		System.out.println(result);
	}

}
