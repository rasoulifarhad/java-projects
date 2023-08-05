package com.farhad.example.smartertype.enums.recap;

import static com.farhad.example.smartertype.util.Show.show;

public class DateOfBirth {
	
	public static void test(int m, int d, int y) {
		show(m + "/" + d + "/" + y);
		show(new BirthDate(Month.number(m), new Day(d), new Year(y)));
	}
	public static void main(String[] args) {
		
		test(7, 8, 1957);
	    test(0, 32, 1857);
		test(2, 31, 2022);
		test(9, 31, 2022);
		test(4, 31, 2022);
		test(6, 31, 2022);
		test(11, 31, 2022);
		test(12, 31, 2022);
		test(13, 31, 2022);
	}
}
