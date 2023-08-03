package com.farhad.example.enums.smartertype;

import static com.farhad.example.enums.smartertype.util.Show.show;

import com.farhad.example.enums.smartertype.util.Check;

public class StarredBad {
	
	static int f1( int stars ) {
		Check.range(0 < stars && stars <= 10, stars);
		return stars * 2;
	}

	static int f2( int stars ) {
		Check.range(0 < stars && stars <= 10 , stars);
		return stars + 4;
	}

	public static void main(String[] args) {
		
		int stars1 = 6;
		show(stars1);
		show(f1(stars1));
		show(f2(stars1));

		int stars2 = 11;
		show(f1(stars2));
		stars1 = 99;
		show(f2(stars1));
	}

}
