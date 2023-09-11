package com.farhad.example.filechannel;

import java.nio.ByteBuffer;

public class ByteByfferMetrics {
	public static void printMetrics(ByteBuffer buffer) {
		System.out.printf("position = %4d, limit = %4d, capacity = %4d, remaining = %4d%n", 
						buffer.position(),
						buffer.limit(),
						buffer.capacity(),
						buffer.remaining());;
	}
}
