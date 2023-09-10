package com.farhad.example.filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ResdDemo {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Path.of("read-demo.bin");
		try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int byteResd;
			while ( (byteResd = channel.read(buffer)) != -1) {
				System.out.printf("bytes read from file: %s%n", byteResd);
				if(byteResd > 0 ) {
					System.out.printf("First byte %d, last byte: %d%n",buffer.get(0), buffer.get(byteResd -1));
				}
				buffer.rewind();				
			}
		} 
	}
}
