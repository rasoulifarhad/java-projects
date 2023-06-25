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

    private static final int QUEUE_CAPACITY = 5;
    private Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new Queue<Integer>(Integer.class, QUEUE_CAPACITY);
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
    public void given_emptyQue_when_callingFront_then_ThrowsExceptionTest() {
        assertThrows(
            NoSuchElementException.class,
            () -> queue.front());
    }

    @Test
    public void given_emptyQue_when_callingRear_then_ThrowsExceptionTest() {
        assertThrows(
            NoSuchElementException.class,
            () -> queue.rear());
    }

    @Test
    public void given_emptyQueue_when_enqueueUntilQueueFulledAfterThat_then_EnqueueThrowsExceptionTest() {
        assertThrows(
            IllegalStateException.class,
            () -> {
                for(int i = 0; i < QUEUE_CAPACITY; i++ ) {
                    queue.enqueue(i);
                }
                queue.enqueue(QUEUE_CAPACITY);
            });
    }

    @Test
    public void queueWrappingAroundTest() {
        log.info("Queue: {}", queue.toString());
        for(int i = 1; i <= 3; i++ ) {
            queue.enqueue(i);
        }
        assertEquals(1, (int)queue.dequeue());
        assertEquals(2, (int)queue.dequeue());
        assertEquals(3, (int)queue.dequeue());

        assertTrue(queue.isEmpty());

        for(int i = 4; i <= 6; i++) {
            queue.enqueue(i);
        }
        assertTrue(queue.size() == 3);
        assertEquals(4, (int) queue.front());
        assertEquals(6, (int) queue.rear());
        assertTrue(queue.size() == 3);
        
        assertEquals(4, (int) queue.dequeue());

        assertEquals(5, (int) queue.front());
        assertEquals(6, (int) queue.rear());
        assertEquals(2, (int)queue.size());
    }

    // when isFull method is  `return size == backedArray.length,`  exception is `java.lang.ArrayIndexOutOfBoundsException: 5`
    // when isFull method is  `return rear == backedArray.length - 1;`  exception is `java.lang.IllegalStateException: Queue is full.(size=4)`
    // WE MUST IMPLEMENT CIRCULAR QUEUE
    @Test
    public void given_EnqueueUntilQueueFull_When_DequeueOneFromQueue_Then_EnqueueTrue() {
        log.info("");
        log.info("Queue: {}", queue.toString());
        // given
        for(int i = 0; i < QUEUE_CAPACITY; i++ ) {
            queue.enqueue(i);
        }
        // when
        queue.dequeue();
        // then
        queue.enqueue(QUEUE_CAPACITY);
    }

    
}
