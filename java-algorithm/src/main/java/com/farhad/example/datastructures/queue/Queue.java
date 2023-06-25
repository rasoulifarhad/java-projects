package com.farhad.example.datastructures.queue;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class Queue<T> {
    
    private int front;
    private int rear;
    private int size;

    private T [] backedArray;

    @SuppressWarnings("unchecked")
    public Queue(Class<T> clazz, int capacity) {
        final T [] a = (T[]) Array.newInstance(clazz, capacity);
        this.backedArray = a;
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        
    }

    public void enqueue(T t) {
        if(isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        if(isEmpty()) {
            front = rear = 0;
            backedArray[0] = t;
        } else {
            rear++;
            backedArray[rear] = t;            
        }
        size++;
    }

    public T dequeue() {

        if(isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        // if(isLast()) {
        if(front == rear) {
            T val = backedArray[front];
            front = rear = -1;
            return val;
        }
        T val = backedArray[front];
        front++;
        size--;
        return val;
    }

    public T front() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return backedArray[front];
    }

    public T rear() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return backedArray[rear];
    }   

    public boolean isEmpty() {
        // return front == -1 || front > rear;
        return size == 0;
    }

    public boolean isFull() {
        // return rear == backedArray.length - 1;
        return size == backedArray.length;
    }

    private boolean isLast() {
        return front >= 0 && rear >=0 && front == rear;
    }

    public int size() { 
        return this.size;
    }
}
