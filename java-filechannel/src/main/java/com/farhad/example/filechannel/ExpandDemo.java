package com.farhad.example.filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ExpandDemo {
	
	public static void main(String[] args) throws IOException {
		Path path = Path.of("1g-demo.bin");
		try (FileChannel channel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
			ByteBuffer buffer = ByteBuffer.allocate(1);
			buffer.put((byte)1);
			buffer.flip();
			
			channel.position( (1 << 30 ) - 1  );
			channel.write(buffer);
		} 
	}
}
