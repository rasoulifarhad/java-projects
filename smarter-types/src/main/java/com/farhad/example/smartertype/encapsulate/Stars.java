package com.farhad.example.enums.smartertype.encapsulate;

import static com.farhad.example.enums.smartertype.util.Check.range;
public class Stars {
	
	private int n;

	public static void validate(int s) {
		range(0 <= s && s <=10 , s);
	}

	Stars(int n) {
		validate(n);
		this.n = n;
	}

	int n() {
		return n;
	}

	Stars f1(Stars stars) {
		n = n % 5 + stars.n * 2;
		validate(n);
		return this;
	}

	Stars f2(Stars stars) {
		n = n % 5 + stars.n + 2;
		validate(n);
		return this;
	}

	static Stars f3(Stars stars1, Stars stars2) {
		return new Stars(stars1.n + stars2.n);
	}

	public String toString() {
		return String.format("Stars(%s)", n);
	}

}


