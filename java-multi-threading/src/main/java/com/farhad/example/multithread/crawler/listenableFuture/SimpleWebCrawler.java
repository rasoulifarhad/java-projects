package com.farhad.example.multithread.crawler.listenableFuture;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.apache.commons.io.IOUtils;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleWebCrawler {

    private final static  ListeningExecutorService pool = MoreExecutors.listeningDecorator( Executors.newFixedThreadPool(10) );
 
    public ListenableFuture<String> startDownloding(URL url) throws IOException {

        final ListenableFuture<String> future = 
                        pool.submit( new Callable<String>() {

                            @Override
                            public String call() throws Exception {
                                return IOUtils.toString(url, StandardCharsets.UTF_8);
                            }
                            
                        } );
        return future ;
    }

    public static void main(String[] args) {
        p1(); 
    }

    private static void p1() {

        SimpleWebCrawler simpleWebCrawler = new SimpleWebCrawler();

        try {
            final ListenableFuture<String> futureContents = simpleWebCrawler.startDownloding( new URL("http://www.example.com") );

            futureContents.addListener(new Runnable() {

                @Override
                public void run() {
                    try {
                        log.info("{}", futureContents.get());
                    } catch (InterruptedException e) {
                        log.error("Interrupted", e);
                    } catch (ExecutionException e) {
                        log.error("Exception in task", e);
                    } 
                }
                
            }, pool);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    private static void p2() {

        SimpleWebCrawler simpleWebCrawler = new SimpleWebCrawler();

        try {
            final ListenableFuture<String> futureContents = simpleWebCrawler.startDownloding( new URL("http://www.example.com") );

            Futures.addCallback(futureContents, new FutureCallback<String>() {

                @Override
                public void onFailure(Throwable t) {
                    log.error("Exception TRhrown", t);
                }

                @Override
                public void onSuccess(String result) {
                    log.info("{}",result);                    
                }
                
            }, pool);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

}
