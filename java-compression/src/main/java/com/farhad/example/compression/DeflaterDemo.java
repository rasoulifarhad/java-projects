package com.farhad.example.compression;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;

public class DeflaterDemo {

    public static byte [] compress(String string) throws IOException {
        return compress(string.getBytes());
    }
    public static byte [] compress(byte [] data) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try (DeflaterOutputStream dos = new DeflaterOutputStream(os)) {
            dos.write(data);
        }
        return os.toByteArray(); 
    }

    public static byte [] decompress(byte [] compressedData) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try (OutputStream ios = new InflaterOutputStream(os)) {
            ios.write(compressedData);
        } 
        return os.toByteArray();
    }

    public static String compressBase64(String text) throws IOException {
        byte [] compressed = compress(text);
        return new String(
            Base64.getEncoder().encode(compressed));
    }
    
    public static String decompressBase64(String base64Compressed) throws IOException {
        byte [] compressed = Base64.getDecoder().decode(base64Compressed);
        byte [] decompressed = decompress(compressed);
        return new String(decompressed, StandardCharsets.UTF_8);

    }

    public static byte [] compress2(byte [] data, int compressionLevel, boolean GZIPFormat) throws IOException {
        // Create a Deflater object to compress data        
        Deflater compresser = new Deflater(compressionLevel, GZIPFormat);
        // Deflater compresser = new Deflater();

        // Set the input for the compressor        
        compresser.setInput(data);

        ByteArrayOutputStream os = new ByteArrayOutputStream(data.length);
        
        // Call the finish() method to indicate that we have
        // no more input for the compressor object
        compresser.finish();
        byte [] buffer = new byte[1024];
        while (!compresser.finished()) {
            int count = compresser.deflate(buffer);
            if(count > 0) { 
                // Write compressed data to the output stream                
                os.write(buffer, 0, count);
            }
        }
        compresser.end();
        // os.close();
        byte [] output = os.toByteArray();
        System.out.println(String.format("Original: %d KB%n", data.length / 1024));
        System.out.println(String.format("Compressed: %d KB%n", output.length / 1024));
        return output;
    }
    
    public static byte [] decompress2(byte [] data, boolean GZIPFormat) throws DataFormatException, IOException {
        // Create an Inflater object to decompress the data        
        Inflater decompresser = new Inflater(GZIPFormat);
        // Inflater decompresser = new Inflater();
        // Set the input for the decompressor        
        decompresser.setInput(data);
        ByteArrayOutputStream os = new ByteArrayOutputStream(data.length);
        byte [] buffer = new byte[1024];
        while (!decompresser.finished()) {
            int count = decompresser.inflate(buffer);
            if (count > 0) {
                // Write the data to the output stream                
                os.write(buffer, 0, count);
            }
        }
        decompresser.end();
        // os.close();
        byte [] output = os.toByteArray();
        System.out.println(String.format("compressed: %d", data.length));
        System.out.println(String.format("Decompressed: %d", data.length));
        return output;
    }

    public static void main(String[] args) throws IOException, DataFormatException {
        String input = "ABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABABAB";
        byte [] uncompressedData = input.getBytes(StandardCharsets.UTF_8);
        byte [] compressedData = compress2(uncompressedData, Deflater.BEST_COMPRESSION, false);

        byte [] decompressedData = decompress2(compressedData, false);

        String output = new String(decompressedData, StandardCharsets.UTF_8);
        System.out.println(input);
        System.out.println(uncompressedData.length);
        System.out.println(compressedData.length);
        System.out.println(decompressedData.length);
        System.out.println(output);

        input = "ABCDEF";
        input =  String.join("", Collections.nCopies(10, input));
        uncompressedData = input.getBytes(StandardCharsets.UTF_8);
        compressedData = compress2(uncompressedData, Deflater.BEST_COMPRESSION, false);
        decompressedData = decompress2(compressedData, false);
        output = new String(decompressedData, StandardCharsets.UTF_8);
        System.out.println("=====================");
        System.out.println(input);
        System.out.println(uncompressedData.length);
        System.out.println(compressedData.length);
        System.out.println(decompressedData.length);
        System.out.println(output);

    }   

}
