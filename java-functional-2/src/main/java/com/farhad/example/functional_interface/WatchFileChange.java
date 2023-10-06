package com.farhad.example.functional_interface;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class WatchFileChange {
    
    public static void main(String[] args) throws IOException, InterruptedException {
         
        final Path path = Paths.get(".");
        final WatchService watchService = 
            path.getFileSystem()
                .newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        System.out.println("Report any file changed within next 1 minute...");
        final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);

        if(watchKey != null) {
            watchKey.pollEvents()
                .stream()
                .forEach(watchEvent -> System.out.println(watchEvent.context()));
        }
    }
}
