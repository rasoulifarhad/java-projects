package com.farhad.example.functional_interface.design_patterns.chainofresponsibility;

import java.util.Optional;

public class ParserUtil {

	public static Optional<String> parseText(File file) {
		return file.getType() == FileType.TEXT ? Optional.of("Text file: " + file.getContent()) : Optional.empty();
	}
	
	public static Optional<String> parseAudio(File file) {
		return file.getType() == FileType.AUDIO ? Optional.of("Audio file: " + file.getContent()) : Optional.empty();
	}
	
	public static Optional<String> parseVideo(File file) {
		return file.getType() == FileType.VIDEO ? Optional.of("Video file: " + file.getContent()) : Optional.empty();
	}
	
}
