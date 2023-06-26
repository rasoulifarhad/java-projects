package com.farhad.example.datastructures.queue;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CircularQueue<T> {
    private int front;
    private int rear;
    private int size;

    private T [] backedArray;

    @SuppressWarnings("unchecked")
    public CircularQueue(Class<T> clazz, int capacity) {
        final T [] a = (T[]) Array.newInstance(clazz, capacity);
        this.backedArray = a;
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        
    }

    public void enqueue(T t) {
        if(isFull()) {
            throw new IllegalStateException(String.format("Queue is full.(size=%d)", size));
        }
        if(isEmpty()) {
            front = rear = 0;
            backedArray[0] = t;
        } else {
            rear++;
            if(rear > backedArray.length - 1 ) {
                rear = 0;
            }
            backedArray[rear] = t;            
        }
        size++;
        log.info("Queue: {}, enqueue: {}", toString(), t);
    }

    public T dequeue() {

        if(isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        if(front > backedArray.length - 1) {
            front = 0;
        }
        T val = backedArray[front];
        front++;
        size--;
        // T val;
        // // if(isLast()) {
        // if(front == rear) {
        //     val = backedArray[front];
        //     front = rear = -1;
        //     size = 0;
        // } else {
        //     val = backedArray[front];
        //     front++;
        //     size--;
        // }
        log.info("Queue: {}, dequeue: {}", toString(), val);
        return val;
    }

    public T front() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T val = backedArray[front];
        log.info("Queue: {}, front: {}", toString(), val );
        return val;
    }

    public T rear() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T val = backedArray[rear]; 
        log.info("Queue: {}, rear: {}", toString(), val);
        return val;
    }   

    public boolean isEmpty() {
        // return front == -1 || front > rear;
        return size == 0;
    }

    public boolean isFull() {
        // return rear == backedArray.length - 1;
        return size == backedArray.length ;
    }

    private boolean isLast() {
        return front >= 0 && rear >=0 && front == rear;
    }

    public int size() { 
        return this.size;
    }

    @Override
    public String toString() {
        return String.format("[ front=%d, rear=%d, size=%d ]", front, rear, size);
    }
}
