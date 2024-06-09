package com.farhad.example.java_tips.count_demo.present;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.farhad.example.java_tips.count_demo.download.TextDownload;
import com.farhad.example.java_tips.count_demo.result.WordCountResultNotParallel;
import com.farhad.example.java_tips.count_demo.result.WordCountResultParallel;
import com.farhad.example.java_tips.count_demo.result.WordCountResultThreadPool;

public class MainParallel {

    private static long start = -1; 
    private static String startedActivity = ""; 


   public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ExecutionException {
        var uri = new URI("https://raw.githubusercontent.com/manum/mr-cassandra/master/mr_cassandra/all-shakespeare.txt");
        Path file = new TextDownload().download(uri);
        List<String> lines = Files.readAllLines(file);
        int repeat = 5;
        for (int i = 0; i < repeat; i++) {
            lines.addAll(lines);
        }

        int limit = 500 * (1 + repeat);

        time("warm up WordCountResultThreadPool");
        new WordCountResultThreadPool().count(lines, limit);
        time("warm up WordCountResultThreadPool");
        new WordCountResultThreadPool().count(lines, limit);
        time("warm up WordCountResultThreadPool");
        List<String> resultPool = new WordCountResultThreadPool().count(lines, limit);

        time("warm up WordCountResultParallel");
        System.out.println();
        new WordCountResultParallel().count(lines, limit);
        time("warm up WordCountResultParallel");
        new WordCountResultParallel().count(lines, limit);
        time("warm up WordCountResultParallel");
        List<String> resultParallel = new WordCountResultParallel().count(lines, limit);

        time("warm up WordCountResultNotParallel");
        System.out.println();
        new WordCountResultNotParallel().count(lines, limit);
        time("warm up WordCountResultNotParallel");
        new WordCountResultNotParallel().count(lines, limit);
        time("warm up WordCountResultNotParallel");
        List<String> result = new WordCountResultNotParallel().count(lines, limit);

        time("");
        System.out.println();

        System.out.println();
        System.out.println("The words below can be found more than " + limit + " times ");
        System.out.println("in The Complete Works of William Shakespeare");
        System.out.println();
        System.out.print("WordCountResult:           ");
        System.out.println(result);
        System.out.print("WordCountResultParallel:   ");
        System.out.println(resultParallel);
        System.out.print("WordCountResultThreadPool: ");
        System.out.println(resultPool);        
    }

    private static void time(String activity) {
        if (start < 0) {
            System.out.println(activity + " started");
            start = System.currentTimeMillis();
            startedActivity = activity;
        } else {
            long end = System.currentTimeMillis();
            System.out.println(startedActivity + " ended in " + (end - start) + " milliseconds" );
            start = end;
            startedActivity = activity;
        }
    }    
}
