package com.farhad.example.generic;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Demo_01 {


	@Getter
	@Setter
	static class Container<T> {
		private T value;

		public List<Integer> getNumbers() {
			return new ArrayList<>();
		}
	}

	// public void traverseNumbersList(Container container) {
	// 	for (int num : container.getNumbers()) { // compile error
	// 		System.out.println(num);
	// 	}
	// }

	public void traverseNumbersList(Container<?> container) {
		for (int num : container.getNumbers()) { // compile error
			System.out.println(num);
		}
	}

}
