package com.farhad.example.tools;

import static com.farhad.example.tools.ThrowingConsumer.handlingConsumerWrapper;
import static com.farhad.example.tools.ThrowingConsumer.throwingConsumerWrapper;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThrowingConsumerTest {
    
    @Test
    public void consumerWrapperTest() {

        List<Integer> ints = Arrays.asList(3, 10, 3, 0, 9, 6);

        ints.forEach(
            throwingConsumerWrapper( i -> log.info("{}", 50 / i)));
    }

    @Test
    public void handlingConsumerWrapperTest() {

        List<Integer> ints = Arrays.asList(3, 10, 3, 0, 9, 6);

        ints.forEach(
            handlingConsumerWrapper( i -> log.info("{}", 50 / i),ArithmeticException.class));
    }

}
