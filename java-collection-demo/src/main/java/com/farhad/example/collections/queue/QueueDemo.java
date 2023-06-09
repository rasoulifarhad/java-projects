package com.farhad.example.collections.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueDemo {
    
    private static final int DEFAULT_TIME = 10;

    static <E> List<E> heapSort(Collection<E> c) {
        Queue<E> queue = new PriorityQueue<>(c);
        List<E> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }
        return result;
    }
    
    public void demonstrateCountdownWithQueue() throws InterruptedException {

        int time = DEFAULT_TIME ;
        Queue<Integer> queue = new LinkedList<>();

        log.info("");
        for (int i = time ; i >= 0 ; i--) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            log.info("process#{} done!", queue.remove());
            Thread.sleep(1000);
        }
        log.info("All done!");
    }

    public void demonstrateHeapSort() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < DEFAULT_TIME; i++) {
            list.add(random.nextInt(Integer.MAX_VALUE));
        }
        log.info("");
        log.info("List:       {}", list);
        List<Integer> sortedList = heapSort(list);
        log.info("Sorted list: {}", sortedList);
    }

    public void demonstrateAnotherHeapSort() {
        List<Integer> list = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        Collections.shuffle(list);
        log.info("");
        log.info("List:       {}", list);
        List<Integer> sortedList = heapSort(list);
        log.info("Sorted list: {}", sortedList);
    }

    public static void main(String[] args) throws InterruptedException {
        QueueDemo demo = new QueueDemo();

        demo.demonstrateCountdownWithQueue();
        demo.demonstrateHeapSort();
        demo.demonstrateAnotherHeapSort();
    }
}
