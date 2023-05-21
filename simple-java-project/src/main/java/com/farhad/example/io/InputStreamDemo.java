package com.farhad.example.io;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

/**
 * InputStream is an abstract class representing a stream of bytes. 
 * 
 * It is a superclass of all classes representing an input stream of bytes. An InputStream can be used to read data from various 
 * sources, such as a file, a network connection, or a byte array.
 * 
 * Some common methods available in InputStream: 
 * 
 * read()  : Reads the next byte of data from the input stream.
 * read(byte[] b) : Reads up to b.length bytes of data from the input stream into an array of bytes.
 * skip(long n) : Skips over and discards n bytes of data from the input stream.
 * ...
 * 
 * BufferedReader: Reads text from a character-input stream, buffering characters so ...
 */

 @Slf4j
public class InputStreamDemo {
    

    public static class BufferedReaderDemo {

        public static String convertInputStreamToString(InputStream inputStream) throws IOException {

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {
                while ( (line = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(line);
                } 
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            return stringBuilder.toString();
        }
    }

    /**
     *  ^ (beginning of a line)  $ (end of a line) \b (word boundary) \B (non-word boundary) \A (beginning of the input) 
     *  \G (end of the previous match) \Z (The end of the input but for the final terminator) \z
     */ 
    public static class ScannerDemo {

        public static String convertInputStreamToString(InputStream inputStream) throws IOException {

            // read the entire input stream as a single token
            String rez = null ;
            try (Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");) {
                
                rez =  scanner.hasNext() ? scanner.next() : "" ;
                    
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            return rez;
        }
    }

    /**
     * This class implements an output stream in which the data is written into a byte array.
     * 
     * The data can be retrieved using toByteArray() and toString().
     */
    public static class ByteArrayOutputStreamDemo {
        public static String convertInputStreamToString(InputStream inputStream) throws IOException {
            ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
            byte[] buffer = new byte[1024];
            int length ;
            while ( (length = inputStream.read(buffer))  != -1 ) {
                bos.write(buffer, 0, length);
            }
            return bos.toString();
        }
    }
}
