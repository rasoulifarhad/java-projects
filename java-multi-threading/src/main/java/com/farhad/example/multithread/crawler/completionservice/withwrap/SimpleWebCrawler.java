package com.farhad.example.multithread.crawler.completionservice.withwrap;

import static com.farhad.example.tools.FunctionTools.wrap;
// import static com.farhad.example.tools.Either.lift;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;

import lombok.extern.slf4j.Slf4j;
/**
 * ExecutorCompletionService wrapper class tries to address one of the biggest deficiencies of Future<T> type - no 
 * support for callbacks or any event-driven behaviour whatsoever.
 * 
 * It is a thin wrapper around ExecutorService that "remembers" all submitted tasks and allows you to wait for the 
 * first completed, as opposed to first submitted task. 
 * 
 * In a way ExecutorCompletionService keeps a handle to all intermediate Future objects and once any of them finishes, 
 * it's returned. Crucial API method is CompletionService.take() that blocks and waits for any underlying Future to 
 * complete.
 *  
 */
@Slf4j
public class SimpleWebCrawler {
    
    private final ExecutorService pool = Executors.newFixedThreadPool(5);
    private final ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(pool);

    public Future<String> startDownloading(URL url) {

        return completionService.submit( new Callable<String>() {

            @Override
            public String call() throws Exception {
                try (InputStream input = url.openStream()) {
                    return IOUtils.toString(input, StandardCharsets.UTF_8);
                } 
            }
        } );
    }

    public Future<String> startDownloading(String site)  {
        List<URL> urls =  Stream.of(site)
                                .map(wrap( s -> new URL("http://" + s) ) )
                                .collect(Collectors.toList());
        return startDownloading( urls.get(0) ) ;
    }

    public List<Future<String>> startDownloading(List<URL> urls) {

        List<Future<String>> contentFutures = new ArrayList<>();
        for (URL url : urls) {
            contentFutures.add(startDownloading(url));            
        }
        return contentFutures;
    }

    public List<Future<String>> startDownloadingSites(List<String> sites) {

        List<URL> urls =  sites.stream()
                                    .map( wrap( site -> new URL("http://" + site) ) )

                                    .collect(Collectors.toList());
        return startDownloading(urls);
    }

    public static void main(String[] args) {
        
    }

    private static void test_2() throws InterruptedException {
        final List<String> topSites = Arrays.asList(
            "www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com",
            "www.wikipedia.org", "www.baidu.com", "www.microsoft.com", "www.qq.com",
            "www.bing.com", "www.ask.com", "www.adobe.com", "www.taobao.com",
            "www.youku.com", "www.soso.com", "www.wordpress.com", "www.sohu.com",
            "www.windows.com", "www.163.com", "www.tudou.com", "www.amazon.com"
        );
        SimpleWebCrawler simpleWebCrawler = new SimpleWebCrawler() ;
        List<Future<String>> contentFutures =  simpleWebCrawler.startDownloadingSites(topSites);
        for (int i = 0; i < contentFutures.size(); i++) {
            
            Future<String>  contentFuture = simpleWebCrawler.completionService.take();
            try {
                log.info("{}", contentFuture.get());
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
