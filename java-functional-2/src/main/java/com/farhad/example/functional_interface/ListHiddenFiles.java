package com.farhad.example.functional_interface;

import java.io.File;
import java.util.Arrays;

public class ListHiddenFiles {
    
    public static void main(String[] args) {
        final File[] files = new File(".").listFiles(file -> file.isHidden());
        System.out.println(Arrays.asList(files));

        final File[] files2 = new File(".").listFiles(File::isHidden);
        System.out.println(Arrays.asList(files2));

    }
}
