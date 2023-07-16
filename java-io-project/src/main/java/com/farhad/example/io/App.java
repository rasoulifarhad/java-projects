package com.farhad.example.io;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class App {

    // filter all the hidden files in a directory
    public static File [] filterHiddenFiles(String dir) {
        return new File(dir).listFiles(new FileFilter() {

            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
            
        });
    }

    public static File[] filterHiddenFilesByMethodReference(String dir) {
        return new File(dir).listFiles(File::isHidden);
    }

    public static File[] filterHiddenFilesByLambda(String dir) {
        return new File(dir).listFiles(f -> f.isHidden());
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(filterHiddenFilesByMethodReference(".")));
    }
}
