package com.farhad.example.bytebuffer;

import static com.farhad.example.bytebuffer.ByteByfferMetrics.printMetrics;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class ByteBufferDemo {
	
	public static void main(String[] args) {
		
		ByteBuffer buffer = ByteBuffer.allocate(1000);
		printMetrics(buffer);
		for (int i = 0; i < 100; i++) {
			buffer.put((byte) 1);
		}
		printMetrics(buffer);

		byte[] twos = new byte[200];
		Arrays.fill(twos, (byte) 2);
		buffer.put(twos);
		printMetrics(buffer);

		buffer.flip();
		printMetrics(buffer);

		buffer.get(new byte[200]);
		printMetrics(buffer);

		buffer.compact();
		printMetrics(buffer);

		byte[] threes = new byte[300];
		Arrays.fill(threes, (byte)3);
		buffer.put(threes);
		printMetrics(buffer);

		buffer.flip();
		printMetrics(buffer);
	}
}
