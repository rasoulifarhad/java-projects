package com.farhad.example.smartertype.encapsulate;

import static com.farhad.example.smartertype.util.Show.show;
public class Starred {
	public static void main(String[] args) {
		
		Stars one = new Stars(1);
		Stars two = new Stars(2);
		Stars three = new Stars(3);
		Stars six = new Stars(6);
		Stars eleven = new Stars(11);

		show(Stars.f3(one, three));
		show(one);
		show(one.f1(two));
		show(one.f2(three));
		show(one.f2(one));
		show(one.f2(one));
	}
}
