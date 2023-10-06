package com.farhad.example.functional_interface;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ListSelectFiles {
    public static void main(String[] args) throws IOException {
        
        final String[] files = 
            new File(".").list(
                new FilenameFilter() {

                    @Override
                    public boolean accept(File dir, String name) {
                        return name.startsWith(".");
                    }
                    
                }
            );
        System.out.println(Arrays.asList(files));
        System.out.println();

        FilenameFilter nameStartWitDot = (dir, name) -> name.startsWith(".");
        final String[] files2 = 
            new File(".").list(nameStartWitDot);
        System.out.println(Arrays.asList(files2));
        System.out.println();

        Files.newDirectoryStream(Paths.get("."), entry -> entry.startsWith("\\."))
                .forEach(System.out::println);

    }
}
