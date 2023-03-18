package com.farhad.example.tools;

import static com.farhad.example.tools.CheckedConsumer.consumerWrapper;
import static com.farhad.example.tools.CheckedConsumer.wrap;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CheckedConsumerTest {
    
    @Test
    public void CheckedConsumer_Test() {

        List<Integer> sleepTimes = Arrays.asList(10, 5, 34, 2, 1, 1000);

        sleepTimes.forEach( wrap( i -> Thread.sleep(i) ) );

        log.info("End...");
    }

    @Test
    public void consumerWrapperTest() {

        List<Integer> ints = Arrays.asList(3, 10, 3, 0, 9, 6);

        ints.forEach(
            consumerWrapper( i -> log.info("{}", 50 / i), ArithmeticException.class));
    }
}
