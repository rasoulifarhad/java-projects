package com.farhad.example.string;

import java.util.Formatter;

import lombok.extern.slf4j.Slf4j;

/**
 * See https://dzone.com/articles/java-string-tutorials
 */
@Slf4j
public class StringFormatingDemo {
    
    public static void main(String[] args) {
        
        String greeting = String.format("Hello, %s", "Farhad");
        log.info("{}", greeting);

        System.out.printf("Hello, %s\n", "Farhad");

        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);
        fmt.format("PI= %f%n", Math.PI);
        log.info("{}", sb.toString());

        greeting = String.format("Hello, %1$s %1$s %1$s", "Farhad");
        log.info("{}", greeting);

        String formatedString = String.format("|%1$10d| - |%1$-10d| - |%1$010d| - |%1$+10d| - |%1$ d| - |%2$ d| ", 95, -95);
        log.info("{}", formatedString);
        formatedString = String.format("|%1$,d| - |%2$,d| - |%2$(,d| ", 10000000, -10000000  );
        log.info("{}", formatedString);
        formatedString = String.format("|%1$o| - |%1$x| - |%1$#o| - |%1$#x| ", 95);
        log.info("{}", formatedString);

        formatedString = String.format("|%1$s| - |%1$15s| - |%1$-15s| - |%1$.5s| - |%1$15.5s| ", "Hello World");
        log.info("{}", formatedString);
        fmt.close();
        
    }
}
