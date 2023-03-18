package com.farhad.example.multithread.crawler.completablefuture;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;

import lombok.extern.slf4j.Slf4j;

/**
 * Having a list of websites our crawler shall start downloading the contents of each web site asynchronously 
 * and concurrently. Then each downloaded HTML string will be parsed to XML Document and later relevance will 
 * be computed. 
 * 
 * As a last step we take all computed relevance metrics and find the biggest one. 
 * 
 * Both downloading content and computing relevance is asynchronous (returns CompletableFuture) and we 
 * definitely don't want to block or busy wait.
 */
@Slf4j
public class SimpleWebCrawler {
    
    private String downloadSitr( final String site ) {

        try {
            log.info("Downloading {}", site);
            final String res = IOUtils.toString(new URL("http://" + site), Charset.forName("utf8"));
            log.info("Done {}", res);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    private Document parse(String xml) {
        return null;
    }

    private CompletableFuture<Double> calculateRelevance(Document doc) {

        return null;
        
    }

    /**
     * Starting from a list of web sites we transform each site (String) into CompletableFuture<String> by submitting asynchronous 
     * task (downloadSite()) into thread pool.
     * 
     * We have a list of CompletableFuture<String>. We continue transforming it, this time applying parse() method on each of 
     * them. thenApply() will invoke supplied lambda when underlying future completes and returns CompletableFuture<Document> 
     * immediately. 
     * 
     * Third and last transformation step composes each CompletableFuture<Document> in the input list with calculateRelevance(). 
     * calculateRelevance() returns CompletableFuture<Double> instead of Double, thus we use thenCompose() rather than thenApply(). 
     * 
     * After that many stages we finally collect() a list of CompletableFuture<Double>.
     * 
     * Now we would like to run some computations on all results. 
     * 
     * We have a list of futures and we would like to know when all of them (last one) complete.
     * 
     * We can register completion callback on each future and use CountDownLatch to block until all callbacks are invoked. 
     * 
     * Or using existing CompletableFuture.allOf().
     * 
     * CompletableFuture.allOf() takes vararg instead of Collection and doesn't return a future of aggregated results but 
     * Void instead.
     * 
     * Aggregated results means: if we provide List<CompletableFuture<Double>> such method should return 
     * CompletableFuture<List<Double>>, not CompletableFuture<Void>!
     * 
     */
    public void calcRelevance() {
        

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<String> topSites = Arrays.asList(
                    "www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com"
                    );
        List<CompletableFuture<Double>> relevanceFutures = 
                                    topSites.stream()
                                            .map( site ->  CompletableFuture.supplyAsync( () -> downloadSitr(site) , executorService))
                                            .map( contentFuture ->  contentFuture.thenApply(this::parse) )
                                            .map( docFuture -> docFuture.thenCompose(this::calculateRelevance) )
                                            .collect(Collectors.<CompletableFuture<Double>>toList());

        CompletableFuture<List<Double>> allDone = sequence(relevanceFutures);

        // when allDone completes, apply our function that counts maximal relevance in whole set. 
        // maxRelevance is still a future. 
        //
        // By the time JVM reaches this line, probably none of the websites are yet downloaded. But we encapsulated 
        // business logic on top of futures, stacking them in an event-driven manner. 
        CompletableFuture<OptionalDouble> maxRelevance = 
                        allDone
                            .thenApply( relevances -> 
                                    relevances
                                        .stream()
                                        .mapToDouble( Double::valueOf )
                                        .max() );
    }

    /**
     * The implementation is surprisingly simple, the trick is to use existing allOf() but when allDoneFuture completes (which means 
     * all underlying futures are done), simply iterate over all futures and join() (blocking wait) on each.
     * 
     * However this call is guaranteed not to block because by now all futures completed!
     * 
     */
    private static <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futures) {

        CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));

        return allDoneFuture.thenApply(v -> 
                    futures.stream()
                            .map( future -> future.join() )
                            .collect( Collectors.<T>toList() ));


    }

    /**
     * getNow(future, () -> expensiveAlternative());
     * or:
     * getNow(future, this::expensiveAlternative);
     */
    public static <T> T getNow( CompletableFuture<T> future , Supplier<T> valueIfAbsent) throws InterruptedException, ExecutionException {

        if ( future.isDone() ) {
            return future.get();
        } else {
            return valueIfAbsent.get();
        }
    }

}
