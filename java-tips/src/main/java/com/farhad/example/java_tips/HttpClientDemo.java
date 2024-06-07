package com.farhad.example.java_tips;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HttpClientDemo {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        new HttpClientDemo().demo();
    }

    private void demo() throws URISyntaxException, IOException, InterruptedException {
        Path destinationPath = new File("out", "shakespeare.txt").toPath();
        URI sourceLocation  = new URI("https://raw.githubusercontent.com/manum/mr-cassandra/master/mr_cassandra/all-shakespeare.txt");
        downloadFile(sourceLocation, destinationPath);
    }

    public void downloadFile(URI sourceLocation, Path destinationPath) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(sourceLocation).build();
        client.send(request, responseInfo -> {
            HttpResponse.BodyHandler<Path> handler = HttpResponse.BodyHandlers.ofFile(destinationPath);
            return handler.apply(responseInfo);
        });
    } 
    
    
}
