package com.farhad.example.another_composite.demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		Component leaf = new Leaf("leaf # 1");

		Composite composite = new Composite();
		composite.add(new Leaf("leaf #2"));
		composite.add(new Leaf("leaf #3"));
		composite.add(new Leaf("leaf #4"));

		Composite nested = new Composite();
		nested.add(new Leaf("leaf nested #1"));
		nested.add(new Leaf("leaf nested #2"));

		composite.add(nested);

		List<Component> components = new ArrayList<>(Arrays.asList(leaf, composite));
		components.forEach(c -> c.operation());
	}
}
