package com.farhad.example.compression;

import static com.farhad.example.compression.DeflaterDemo.compress;
import static com.farhad.example.compression.DeflaterDemo.compressBase64;
import static com.farhad.example.compression.DeflaterDemo.decompress;
import static com.farhad.example.compression.DeflaterDemo.decompressBase64;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

public class DeflaterDemoTest {

    String testStringA = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    String testStringAB = "ABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABAB";
    String testStringABC = "ABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABC";

    @Test
    public void demonstrateCompression() throws IOException {
        String hello = "Hellow world!";
        byte [] compressed = compress(hello.getBytes());

        byte [] decompressed = decompress(compressed);
        System.out.println(new String(decompressed));

        byte [] raw = testStringA.getBytes();
        compressed = compress(raw);
        System.out.println(String.format("Raw data size: %d , Compressed data size: %d%n", raw.length, compressed.length));
        decompressed = decompress(compressed);
        System.out.println(new String(decompressed, StandardCharsets.UTF_8));

        raw = testStringAB.getBytes();
        compressed = compress(raw);
        System.out.println(String.format("Raw data size: %d , Compressed data size: %d%n", raw.length, compressed.length));
        decompressed = decompress(compressed);
        System.out.println(new String(decompressed, StandardCharsets.UTF_8));


        raw = testStringABC.getBytes();
        compressed = compress(raw);
        System.out.println(String.format("Raw data size: %d , Compressed data size: %d%n", raw.length, compressed.length));
        decompressed = decompress(compressed);
        System.out.println(new String(decompressed, StandardCharsets.UTF_8));
    }

    @Test
    public void demonstrateBase64() throws IOException {
        String compressedBase64 = compressBase64(testStringA);
        System.out.println(String.format("Compressed data : %s%n", compressedBase64));
        String decompressed = decompressBase64(compressedBase64);
        System.out.println(String.format("Decompressed(Original) data : %s%n", decompressed));

        compressedBase64 = compressBase64(testStringAB);
        System.out.println(String.format("Compressed data : %s%n", compressedBase64));
        decompressed = decompressBase64(compressedBase64);
        System.out.println(String.format("Compressed data : %s%n", decompressed));

        compressedBase64 = compressBase64(testStringABC);
        System.out.println(String.format("Compressed data : %s%n", compressedBase64));
        decompressed = decompressBase64(compressedBase64);
        System.out.println(String.format("Compressed data : %s%n", decompressed));
    }
}
