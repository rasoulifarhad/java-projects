package com.farhad.example.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IOStreamsDemo {
    
    // Both copyWithByteStream and copyWithCharacterStream use an int variable to read to and write from. However, in CopyCharacters, the int 
    // variable holds a character value in its last 16 bits; in CopyBytes, the int variable holds a byte value in its last 8 bits. 
    //
    // Character streams are often "wrappers" for byte streams. The character stream uses the byte stream to perform the physical I/O, while 
    // the character stream handles translation between characters and bytes. FileReader, for example, uses FileInputStream, while FileWriter 
    // uses FileOutputStream.   
    //
    // There are two general-purpose byte-to-character "bridge" streams: InputStreamReader and OutputStreamWriter. Use them to create character 
    // streams when there are no prepackaged character stream classes that meet your needs.
    public static void copyWithByteStream(String src, String dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);

            int c;
            while( (c = in.read()) != -1 ) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    // Both copyWithByteStream and copyWithCharacterStream use an int variable to read to and write from. However, in CopyCharacters, the int 
    // variable holds a character value in its last 16 bits; in CopyBytes, the int variable holds a byte value in its last 8 bits.
    // 
    // Character streams are often "wrappers" for byte streams. The character stream uses the byte stream to perform the physical I/O, while 
    // the character stream handles translation between characters and bytes. FileReader, for example, uses FileInputStream, while FileWriter 
    // uses FileOutputStream.
    // 
    // There are two general-purpose byte-to-character "bridge" streams: InputStreamReader and OutputStreamWriter. Use them to create character 
    // streams when there are no prepackaged character stream classes that meet your needs.
    public static void copyWithCharacterStream(String src, String dest) throws IOException {
        FileReader in = null;
        FileWriter out = null;
        try {
            in = new FileReader(src);
            out = new FileWriter(dest);

            int c;
            while( (c = in.read()) != -1 ) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    // Character I/O usually occurs in bigger units than single characters. One common unit is the line: a string of characters with a line 
    // terminator at the end. A line terminator can be a carriage-return/line-feed sequence ("\r\n"), a single carriage-return ("\r"), or a 
    // single line-feed ("\n"). Supporting all possible line terminators allows programs to read text files created on any of the widely used 
    // operating systems.
    //
    // Buffered input streams read data from a memory area known as a buffer; the native input API is called only when the buffer is 
    // empty. Similarly, buffered output streams write data to a buffer, and the native output API is called only when the buffer is 
    // full.
    //
    // There are four buffered stream classes used to wrap unbuffered streams: BufferedInputStream and BufferedOutputStream create buffered 
    // byte streams, while BufferedReader and BufferedWriter create buffered character streams.
    //
    // It often makes sense to write out a buffer at critical points, without waiting for it to fill. This is known as flushing the buffer.
    // 
    // Some buffered output classes support autoflush, specified by an optional constructor argument. When autoflush is enabled, certain key 
    // events cause the buffer to be flushed. For example, an autoflush PrintWriter object flushes the buffer on every invocation of println 
    // or format.
    //
    // To flush a stream manually, invoke its flush method. The flush method is valid on any output stream, but has no effect unless the stream 
    // is buffered.
    public static void copyLines(String src, String dest) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new FileReader(src));
            out = new PrintWriter(new FileWriter(dest));
            String line;
            while ( (line = in.readLine()) != null ) {
                out.println(line);
            }

        } finally {
            if (in != null) {
                in.close();
            }
            if (out !=null){
                out.close();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader cin = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(cin);
        System.out.println("Enter line:hi boy");
        String s = br.readLine();
        log.info("entered: {}", s);
        br.close();        
    }

}
