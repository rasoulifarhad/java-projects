package com.farhad.example.filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ThreadLocalRandom;

public class WriteDemo {
	
	public static void main(String[] args) throws IOException {
		Path path = Path.of("write-demo.bin");
		try (FileChannel  channel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
			ByteBuffer buffer = ByteBuffer.allocate(1024);

			for (int i = 0; i < 10; i++) {
				int bytesToWrite = ThreadLocalRandom.current().nextInt(buffer.capacity());
				for (int j = 0; j < bytesToWrite; j++) {
					buffer.put((byte) ThreadLocalRandom.current().nextInt(256));	
				}

				buffer.flip();
				channel.write(buffer);
				buffer.compact();
			}
			buffer.flip();
			while (buffer.hasRemaining()) {
				channel.write(buffer);
			}
		} 
	}
}
