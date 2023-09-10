package com.farhad.example.filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ThreadLocalRandom;

public class AnotherReadDemo {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Path.of("read-demo.bin");
		try ( FileChannel channel = FileChannel.open(path, StandardOpenOption.READ) ) {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int byteReaded;
			while ( (byteReaded = channel.read(buffer)) != -1 ) {
				System.out.printf("bytes read from file: 5d%n", byteReaded);
				long sum = 0;
				buffer.flip();
				int numberOfBytesToRead = ThreadLocalRandom.current().nextInt(buffer.remaining());
				for (int i = 0; i < numberOfBytesToRead; i++) {
					sum += buffer.get();
				}
				System.out.printf(" bytes read from buffer: %d. sum of bytes: %d%n", numberOfBytesToRead, sum);
				buffer.compact();
			}

		} 
	}
}
