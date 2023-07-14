package com.farhad.example.compression;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.junit.jupiter.api.Test;

import com.farhad.example.compression.GZIPDemo.Bill;

public class GZIPDemoTest {

    @Test
    public void demonstrateGZIPOutputStream() throws IOException, ClassNotFoundException {
                Path file = Paths.get("file.dat");
                Files.deleteIfExists(file);
                file = Files.createFile(file);
                try (
                    FileOutputStream f = new FileOutputStream(file.toFile());
                    GZIPOutputStream g = new GZIPOutputStream(f);
                    ObjectOutputStream o = new ObjectOutputStream(g);
                ) {
                    
                    Bill bill = new Bill("1234", "farhad");
                    o.writeObject(bill);
                    o.flush();
                } 
                try (
                    FileInputStream f = new FileInputStream(file.toFile());
                    GZIPInputStream g = new GZIPInputStream(f);
                    ObjectInputStream o = new ObjectInputStream(g);
                ) {
                    Bill bill = (Bill) o.readObject();
                    System.out.println(bill);
                }

                Files.deleteIfExists(file);
    }
}
