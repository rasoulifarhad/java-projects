package com.farhad.example.functional_interface.design_patterns.chainofresponsibility;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		
		File file = new File(FileType.AUDIO, "Dream Theater  - The Astonishing");

		String result = Stream.<Function<File, Optional<String>>>of(ParserUtil::parseText, ParserUtil::parseAudio, ParserUtil::parseVideo)
				.map(f -> f.apply(file))
				.filter(Optional::isPresent)
				.findFirst()
				.flatMap(Function.identity())
				.orElseThrow(() -> new RuntimeException("Unknown file: " + file.toString()));
		System.out.println(result);
	}
}
