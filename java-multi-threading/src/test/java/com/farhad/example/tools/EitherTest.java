package com.farhad.example.tools;

import static com.farhad.example.tools.Either.lift;
import static com.farhad.example.tools.Either.liftWithValue;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;;

@Slf4j
public class EitherTest {
    
    AtomicInteger counter = new AtomicInteger(0);


    @Test
    public void either_basic_test() {

        topSites()
            .stream()
            .map( lift( site -> mapToURL(site) ) )
            .forEach(either -> log.info("{}",either.toString()));
            ;
    }

    @Test
    public void either_exception_test() {

        topSites()
            .stream()
            .map( lift( site -> anotherMapToURL(site) ) )
            .forEach(either -> log.info("{}",either.toString()));
            ;
    }

    @Test
    public void either_and_filter_exceptions_or_filter_righttest() {

        topSites()
            .stream()
            .map( lift( site -> anotherMapToURL(site) ) )
            .forEach(either -> log.info("{}",either.toString()));
            ;

        log.info("------------------------------------------");    

        topSites()
            .stream()
            .map( lift( site -> anotherMapToURL(site) ) )
            .filter( Either::isRight )
            .forEach(either -> log.info("{}",either.toString()));
            ;

        log.info("------------------------------------------");    

        topSites()
            .stream()
            .map( lift( site -> anotherMapToURL(site) ) )
            .filter( Either::isLeft )
            .forEach(either -> log.info("{}",either.toString()));
            ;

    }

    @Test
    public void either_with_pair_and_filter_exceptions_or_filter_righttest() {

        topSites()
            .stream()
            .map( liftWithValue( site -> anotherMapToURL(site) ) )
            .forEach(either -> log.info("{}",either.toString()));
            ;

        log.info("------------------------------------------");    

        topSites()
            .stream()
            .map( liftWithValue( site -> anotherMapToURL(site) ) )
            .filter( Either::isRight )
            .forEach(either -> log.info("{}",either.toString()));
            ;

        log.info("------------------------------------------");    
        
        topSites()
            .stream()
            .map( liftWithValue( site -> anotherMapToURL(site) ) )
            .filter( Either::isLeft )
            .forEach(either -> log.info("{}",either.toString()));
            ;

    }



    private List<String> topSites() {
        return  Arrays.asList(
                    "www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com",
                    "www.wikipedia.org", "www.baidu.com", "www.microsoft.com", "www.qq.com",
                    "www.bing.com", "www.ask.com", "www.adobe.com", "www.taobao.com",
                    "www.youku.com", "www.soso.com", "www.wordpress.com", "www.sohu.com",
                    "www.windows.com", "www.163.com", "www.tudou.com", "www.amazon.com"
                );
    }

    private URL mapToURL(String site ) throws Exception {
        try {
            return new URL("http://" + site);
        } catch (Exception e) {
            throw e ;
        }
    }

    private URL anotherMapToURL(String site ) throws Exception {
        boolean exceptionTrown = ThreadLocalRandom.current().nextBoolean();
        if ( exceptionTrown ) {
            throw new Exception("Exception #" + counter.incrementAndGet());
        }
        try {
            return new URL("http://" + site);
        } catch (Exception e) {
            throw e ;
        }
    }
}
