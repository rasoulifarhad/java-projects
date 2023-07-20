package com.farhad.example.designpatterns.chainofresponsibility;

import com.farhad.example.designpatterns.chainofresponsibility.ChainOfResponsibilityGof.File.Type;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class ChainOfResponsibilityGof {
    
    interface FileParser {
        String parse(File file);
        void setNextParser(FileParser next);
    }

    public abstract static class AbstractFileParser implements FileParser {

        protected FileParser next;

        @Override
        public void setNextParser(FileParser next) {
            this.next = next;
        }
    }

    public static class TextFileParser extends AbstractFileParser {

        @Override
        public String parse(File file) {
            if (file.getType() == Type.TEXT) {
                return String.format("Text file: %s%n", file.getContent());
            } else if (next != null) {
                return next.parse(file);
            } else {
                throw new RuntimeException("Unknown file: " + file);
            }
        }
    }

    public static class PresentationFileParser extends AbstractFileParser {

        @Override
        public String parse(File file) {
            if (file.getType() == Type.PRESENTATION) {
                return String.format("Presentation file: %s%n", file.getContent());
            } else if (next != null) {
                return next.parse(file);
            } else {
                throw new RuntimeException("Unknown file: " + file);
            }
        }
    }

    public static class AudioFileParser extends AbstractFileParser {

        @Override
        public String parse(File file) {
            if (file.getType() == Type.AUDIO) {
                return String.format("Audio file: %s%n", file.getContent());
            } else if (next != null) {
                return next.parse(file);
            } else {
                throw new RuntimeException("Unknown file: " + file);
            }
        }
    }

    public static class VideoFileParser extends AbstractFileParser {

        @Override
        public String parse(File file) {
            if (file.getType() == Type.VIDEO) {
                return String.format("Video file: %s%n", file.getContent());
            } else if (next != null) {
                return next.parse(file);
            } else {
                throw new RuntimeException("Unknown file: " + file);
            }
        }
    }

    public static void main(String[] args) {
        FileParser textFileParser = new TextFileParser();    
        FileParser presentationFileParser = new PresentationFileParser();
        FileParser videoFileParser = new VideoFileParser();
        FileParser audioFileParser = new AudioFileParser();

        textFileParser.setNextParser(presentationFileParser);
        presentationFileParser.setNextParser(videoFileParser);
        videoFileParser.setNextParser(audioFileParser);

        File file = new File(Type.AUDIO, "Music - yanni");
        System.out.println(textFileParser.parse(file));
    }


    @RequiredArgsConstructor
    @Data
    public static class File {
        enum Type { TEXT, PRESENTATION, AUDIO, VIDEO}

        private final Type type;
        private final String content;
    }
}

