package com.farhad.example.smartertype.enums;

import static com.farhad.example.smartertype.enums.Stars.FOUR;
import static com.farhad.example.smartertype.enums.Stars.ONE;
import static com.farhad.example.smartertype.enums.Stars.TEN;
import static com.farhad.example.smartertype.enums.Stars.THREE;
import static com.farhad.example.smartertype.enums.Stars.TWO;
import static com.farhad.example.smartertype.util.Show.show;

public class EnumStars {
	
	public static Stars f1(Stars stars) {
		return Stars.index(stars.n * 2 );
	}

	public static Stars f2(Stars stars) {
		return Stars.index(stars.n + 4);
	}

	public static Stars f3(Stars s1, Stars s2) {
		return Stars.index(s1.n + s2.n);
	}

	public static void main(String[] args) {
		show(Stars.ONE);
		show(f1(TWO));
		show(f1(THREE));
		show(f2(TWO));
		show(f2(THREE));
		show(f3(ONE, FOUR));
		show(f3(THREE, THREE));
		try {
			f3(TEN, TEN);
		} catch (Exception e) {
			show(e);
		}
	}
}
