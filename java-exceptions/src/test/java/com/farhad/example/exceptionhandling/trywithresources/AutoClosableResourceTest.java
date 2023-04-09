package com.farhad.example.exceptionhandling.trywithresources;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutoClosableResourceTest {
    
    private void tryWithResourcesSingleResource_throwExceptionOnClose_false() throws Exception  {

        try (AutoClosableResource autoClosableResource = new AutoClosableResource("One", false)) {
            autoClosableResource.doSomething(false);
        }
    }

    @Test
    public void tryWithResourcesSingleResource_throwExceptionOnClose_false_test() {

        try {
            tryWithResourcesSingleResource_throwExceptionOnClose_false();
        } catch (Exception e) {
            e.printStackTrace();
            Throwable[] suppressed = e.getSuppressed();
            log.info("# of exceptions suppressed {}", (suppressed != null ? suppressed.length : 0));
            log.info("suppressed: {}", Arrays.toString(suppressed));
        }
    }

    private void tryWithResourcesSingleResource_throwExceptionOnClose_true() throws Exception  {

            try (AutoClosableResource autoClosableResource = new AutoClosableResource("One", true)) {
                autoClosableResource.doSomething(false);
            }
    }

    @Test
    public void tryWithResourcesSingleResource_throwExceptionOnClose_true_test() {

        try {
            tryWithResourcesSingleResource_throwExceptionOnClose_true();
        } catch (Exception e) {
            e.printStackTrace();
            Throwable[] suppressed = e.getSuppressed();
            log.info("# of exceptions suppressed {}", (suppressed != null ? suppressed.length : 0));
            log.info("suppressed: {}", Arrays.toString(suppressed));
        }
    }

    private void tryWithResourcesSingleResource_throwExceptionOnClose_true_throwException_true() throws Exception  {

        try (AutoClosableResource autoClosableResource = new AutoClosableResource("One", true)) {
            autoClosableResource.doSomething(true);
        }
    }

    @Test
    public void tryWithResourcesSingleResource_throwExceptionOnClose_true_throwException_true_test() throws Exception  {

        try {
            tryWithResourcesSingleResource_throwExceptionOnClose_true_throwException_true();
        } catch (Exception e) {
            e.printStackTrace();
            Throwable[] suppressed = e.getSuppressed();
            log.info("# of exceptions suppressed {}", (suppressed != null ? suppressed.length : 0));
            log.info("suppressed: {}", Arrays.toString(suppressed));
        }
    }

    private void tryWithResourcesTwoResources_throwExceptionOnClose_true_resourceOne_throwException_true_resourceTwo_throwException_false() throws Exception  {

        try (AutoClosableResource resourceOne = new AutoClosableResource("One", true);
        AutoClosableResource resourceTwo = new AutoClosableResource("Two", true)) {
            resourceOne.doSomething(true);
            resourceTwo.doSomething(false);
        }
    }

    @Test 
    public void tryWithResourcesTwoResources_throwExceptionOnClose_true_resourceOne_throwException_true_resourceTwo_throwException_false_test() {

        try {
            tryWithResourcesTwoResources_throwExceptionOnClose_true_resourceOne_throwException_true_resourceTwo_throwException_false();
        } catch (Exception e) {
            e.printStackTrace();
            Throwable[] suppressed = e.getSuppressed();
            log.info("# of exceptions suppressed {}", (suppressed != null ? suppressed.length : 0));
            log.info("suppressed: {}", Arrays.toString(suppressed));
        }

    }

    @Test
    public void tryWithResourcesWithCatchSingleResource_throwExceptionOnClose_true_throwException_true() throws Exception  {

        try (AutoClosableResource autoClosableResource = new AutoClosableResource("One", true)) {
            autoClosableResource.doSomething(true);
        } catch (Exception e) {
            e.printStackTrace();
            Throwable[] suppressed = e.getSuppressed();
            log.info("# of exceptions suppressed {}", (suppressed != null ? suppressed.length : 0));
            log.info("suppressed: {}", Arrays.toString(suppressed));
        }
    }

    private void tryWithResourcesSingleResource_throwExceptionOnClose_true_with_finally() throws Exception  {

        try (AutoClosableResource autoClosableResource = new AutoClosableResource("One", true)) {
            autoClosableResource.doSomething(false);
        }
    }

    @Test
    public void tryWithResourcesSingleResource_throwExceptionOnClose_true_with_finally_test() throws Exception {

        try {
            tryWithResourcesSingleResource_throwExceptionOnClose_true_with_finally();
        } catch (Exception e) {
            e.printStackTrace();
            Throwable[] suppressed = e.getSuppressed();
            log.info("# of exceptions suppressed {}", (suppressed != null ? suppressed.length : 0));
            log.info("suppressed: {}", Arrays.toString(suppressed));
        } finally {
            throw new Exception("Hey, an exception from the finally block");
        }
    }

    private void tryWithResourcesSingleResource_throwExceptionOnClose_true_with_finally_2() throws Exception  {

        Exception finalException = null;
        try (AutoClosableResource autoClosableResource = new AutoClosableResource("One", true)) {
            autoClosableResource.doSomething(false);
        } catch (Exception e) {
            finalException = new Exception("Error .....");
            finalException.addSuppressed(e);
            for (Throwable suppressed : e.getSuppressed()) {
                finalException.addSuppressed(suppressed);
            }
        } finally {
            if (finalException != null) {
                throw finalException;
            }
        }
    }

    @Test
    public void tryWithResourcesSingleResource_throwExceptionOnClose_true_with_finally_2_test() throws Exception {
        try {
            tryWithResourcesSingleResource_throwExceptionOnClose_true_with_finally();
        } catch (Exception e) {
            e.printStackTrace();
            Throwable[] suppressed = e.getSuppressed();
            log.info("# of exceptions suppressed {}", (suppressed != null ? suppressed.length : 0));
            log.info("suppressed: {}", Arrays.toString(suppressed));
        } 
    }

}
