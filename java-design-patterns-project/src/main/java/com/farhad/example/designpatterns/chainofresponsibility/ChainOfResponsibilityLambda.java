package com.farhad.example.designpatterns.chainofresponsibility;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import com.farhad.example.designpatterns.chainofresponsibility.ChainOfResponsibilityLambda.File.Type;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class ChainOfResponsibilityLambda {
    
    public static Optional<String> parseText(File file) {
        return file.getType() == Type.TEXT ? 
                Optional.of("Text File: " + file.getContent()) :
                Optional.empty();
    }

    public static Optional<String> parsePresentation(File file) {
        return file.getType() == Type.PRESENTATION ? 
                Optional.of("Peresentation File: " + file.getContent()) :
                Optional.empty();
    }
    public static Optional<String> parseVideo(File file) {
        return file.getType() == Type.VIDEO ? 
                Optional.of("Video File: " + file.getContent()) :
                Optional.empty();
    }
    public static Optional<String> parseAudio(File file) {
        return file.getType() == Type.AUDIO ? 
                Optional.of("Audio File: " + file.getContent()) :
                Optional.empty();
    }

    public static void main(String[] args) {

        File file = new File(Type.AUDIO, "Music - yanni");

        System.out.println(
            Stream.<Function<File, Optional<String>>>of(
            ChainOfResponsibilityLambda::parseText,
            ChainOfResponsibilityLambda::parsePresentation,
            ChainOfResponsibilityLambda::parseVideo,
            ChainOfResponsibilityLambda::parseAudio
            )
            .map(f -> f.apply(file))
            .filter(Optional::isPresent)
            .findFirst()
            .flatMap(Function.identity())
            .orElseThrow(() -> new RuntimeException("Unknown File: " + file))
        );
    }

    @RequiredArgsConstructor
    @Data
    public static class File {
        enum Type { TEXT, PRESENTATION, AUDIO, VIDEO}

        private final Type type;
        private final String content;
    }
}
