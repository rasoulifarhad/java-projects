package com.farhad.example.datastructures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new Queue<Integer>(Integer.class, 5);
    }

    @AfterEach
    public void tearDown() {
        queue = null;
    }

    @Test
    public void emptyQueueReturnsTrueTest() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void emptyQueueHasSizeZeroTest() {
        assertTrue(queue.size() == 0);
        assertEquals(0, queue.size());
    }

    @Test
    public void dequeueEmptyQueueThrowsExceptionTest() {
        assertThrows(
            NoSuchElementException.class,
            () -> queue.dequeue()); 
    }

    @Test
    public void getFrontEmptyQueueThrowsExceptionTest() {
        assertThrows(
            NoSuchElementException.class,
            () -> queue.front());
    }

    @Test
    public void getRearEmptyQueueThrowsExceptionTest() {
        assertThrows(
            NoSuchElementException.class,
            () -> queue.rear());
    }

    @Test
    public void eenqueueFullQueueThrowsExceptionTest() {
        assertThrows(
            IllegalStateException.class,
            () -> {
                for(int i = 0; i < 10; i++ ) {
                    queue.enqueue(i);
                }
            });
    }

    
}
