package com.farhad.example.execute_around;

import java.io.FileWriter;
import java.io.IOException;

public class App {
    
    public static void main(String[] args) throws IOException {
        
        new SimpleFileWriter("test-file.txt", new FileWriterAction() {

            @Override
            public void writeFile(FileWriter writer) throws IOException {
                writer.write("Hello");
                writer.append(" ");
                writer.append("World!");
            }
            
        });
    }
}
