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
public class CircularQueueTest {

    private static final int QUEUE_CAPACITY = 5;
    private CircularQueue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new CircularQueue<Integer>(Integer.class, QUEUE_CAPACITY);
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

    @Test
    public void given_enqueueUntilQueueFull_when_DequeueOneAndEnqueueOneAndDequeue3FromQueue_then_2dequeueTrue(){

        log.info("Queue: {}", queue.toString());
       
        // Given
        //// In start state is: Queue: [ front=-1, rear=-1, size=0 ]
        for(int i = 0; i < QUEUE_CAPACITY; i++) {
            queue.enqueue(i);
        }
       
        // When
        //// Now state is: Queue: [ front=0, rear=4, size=5 ]
        queue.dequeue();
        queue.enqueue(QUEUE_CAPACITY);
        //// Now state is: Queue: [ front=1, rear=0, size=5 ]
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        //// now state is: Queue: [ front=4, rear=0, size=2 ]
        
        // Then
        queue.dequeue();
        //// Now state is: Queue: [ front=5, rear=0, size=1 ]
        queue.dequeue();
        //// No state is: Queue: [ front=1, rear=0, size=0 ]
    }
    
    @Test
    public void given_enqueueUntilQueueFull_when_DequeueOneAndEnqueueOneAndDequeue3FromQueue_then_2dequeueAnddddTrue(){

        log.info("Queue: {}", queue.toString());
       
        // Given
        //// In start state is: Queue: [ front=-1, rear=-1, size=0 ]
        for(int i = 0; i < QUEUE_CAPACITY; i++) {
            queue.enqueue(i);
        }
       
        // When
        //// Now state is: Queue: [ front=0, rear=4, size=5 ]
        queue.dequeue();
        queue.enqueue(QUEUE_CAPACITY);
        //// Now state is: Queue: [ front=1, rear=0, size=5 ]
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        //// now state is: Queue: [ front=4, rear=0, size=2 ]
        
        // Then
        queue.dequeue();
        //// Now state is: Queue: [ front=5, rear=0, size=1 ]
        queue.dequeue();
        //// No state is: Queue: [ front=1, rear=0, size=0 ]
        queue.enqueue(QUEUE_CAPACITY + 1);
        //// No state is: Queue: [ front=0, rear=0, size=1 ]
        queue.dequeue();
        //// No state is: Queue: [ front=1, rear=0, size=0 ]
        queue.enqueue(QUEUE_CAPACITY + 2);

    }    
}