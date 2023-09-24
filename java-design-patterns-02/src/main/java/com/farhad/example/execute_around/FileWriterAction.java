package com.farhad.example.execute_around;

import java.io.FileWriter;
import java.io.IOException;

public interface FileWriterAction {
    void writeFile(FileWriter writer) throws IOException;
}
