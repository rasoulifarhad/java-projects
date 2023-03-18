package com.farhad.example.multithread.crawler.simple;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleWebCrawler {
 
    public String downlodContents(URL url) throws IOException {

        try (InputStream input = url.openStream()) {
            return IOUtils.toString(input, StandardCharsets.UTF_8);
        } 
    }

    public static void main(String[] args) {
        
        SimpleWebCrawler simpleWebCrawler = new SimpleWebCrawler();

        try {
            final String contents = simpleWebCrawler.downlodContents( new URL("http://www.example.com") );
            log.info("{}", contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
