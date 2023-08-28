package com.farhad.example.javaidioms.passbyreference;

public class PassByReference {
	

	static class Wrapper {
		public int value;
	}

	static void incrementValue(Wrapper wrapper) {
		wrapper.value++;
	} 

	public static void main(String[] args) {
		
		Wrapper wrapper = new Wrapper();
		wrapper.value = 10;
		incrementValue(wrapper);
		System.out.println(wrapper.value);
	}
	
}
