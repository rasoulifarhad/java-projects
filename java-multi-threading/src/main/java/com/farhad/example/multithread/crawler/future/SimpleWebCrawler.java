package com.farhad.example.multithread.crawler.future;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * How do you actually obtain an instance of Future<T> in your application? 
 * 
 * Two most common sources are thread pools and asynchronous methods (backed by thread pools for you).
 */
@Slf4j
public class SimpleWebCrawler {
    
    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    /**
     * wrap long-running computations in Callable<String> and submit() them to a thread pool.
     * 
     * Submitting returns some implementation of Future<String>, most likely somehow linked to your task 
     * and thread pool.
     * 
     * Task is not executed immediately. instead it is placed in a queue which is later (maybe even much 
     * later) polled by thread from a pool. 
     * 
     */
    public Future<String> startDownloading(URL url) {
        return pool.submit( new Callable<String>() {

                @Override
                public String call() throws Exception {
                    try (InputStream input = url.openStream()) {
                        return IOUtils.toString(input, StandardCharsets.UTF_8);
                    } 
                        }
                
            } );
    }

    public Future<String> startDownloading(String site)  {
       return startDownloading( tryURL(site) ) ;
    }

    public List<Future<String>> startDownloading(List<URL> urls)  {

        List<Future<String>> contentFutures = new ArrayList<>();
        for (URL url : urls) {
            contentFutures.add(startDownloading(url));            
        }
        return contentFutures;
    }

    public List<Future<String>> startDownloadingSites(List<String> sites) {

        List<URL> urls =  sites.stream()
                                    .map( this::tryURL )
                                    .collect(Collectors.toList());
        return startDownloading(urls);
    }

    private URL tryURL(String site) {

        try {
            return new URL("http://" + site) ;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);

        }
    }
    public static void main(String[] args) {
        
        SimpleWebCrawler simpleWebCrawler = new SimpleWebCrawler();

        try {
            final Future<String> futureContents = simpleWebCrawler.startDownloading( new URL("http://www.example.com") );
            while (!futureContents.isDone()) {
                Thread.sleep(50);
            }

            log.info("{}", futureContents.get());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void test_2() throws IOException, InterruptedException {
        final List<String> topSites = Arrays.asList(
            "www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com",
            "www.wikipedia.org", "www.baidu.com", "www.microsoft.com", "www.qq.com",
            "www.bing.com", "www.ask.com", "www.adobe.com", "www.taobao.com",
            "www.youku.com", "www.soso.com", "www.wordpress.com", "www.sohu.com",
            "www.windows.com", "www.163.com", "www.tudou.com", "www.amazon.com"
        );
        SimpleWebCrawler simpleWebCrawler = new SimpleWebCrawler() ;
        List<Future<String>> contentFutures =  simpleWebCrawler.startDownloadingSites(topSites);
        for (Future<String> contentFuture : contentFutures) {
            String content;
            try {
                content = contentFuture.get();
                log.info("{}", content);
        
            } catch (ExecutionException e) {
                log.warn("Error while downloading", e.getCause());            
            }
        }
            
    }

    private static void test_1() {

        SimpleWebCrawler simpleWebCrawler = new SimpleWebCrawler();

        try {
            final Future<String> futureContents = simpleWebCrawler.startDownloading( new URL("http://www.example.com") );
            while (!futureContents.isDone()) {
                Thread.sleep(50);
            }

            log.info("{}", futureContents.get());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
