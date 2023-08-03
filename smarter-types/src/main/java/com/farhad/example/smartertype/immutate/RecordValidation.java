package com.farhad.example.smartertype.immutate;

import static com.farhad.example.smartertype.util.Show.show;

public class RecordValidation {
	
	public static Stars f1(Stars stars) {
		return new Stars(stars.n() * 2);
	}

	public static Stars f2(Stars stars) {
		return new Stars(stars.n() + 4);
	}

	public static Stars f3(Stars s1, Stars s2) {
		return new Stars(s1.n() + s2.n());
	} 

	public static void main(String[] args) {
		
		Stars [] s = {
			new Stars(1), new Stars(3),
			new Stars(4), new Stars(6),
			new Stars(11)
		};

		show( s[1] );
		show( f1(s[1]) );
		show( f1(s[3]) );
		show( f2(s[2]) );
		show( f2(s[3]) );
		show( f3(s[1], s[3]) );
		show( f3(s[3], s[3]) );

	}
}
