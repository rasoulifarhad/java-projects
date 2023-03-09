package com.farhad.example.work;

import java.util.concurrent.atomic.AtomicInteger;

public class ExpensiveRunableTask implements RunableTask {
    
    private static final AtomicInteger taskIdSupplier = new AtomicInteger(0);

    private final int  id ;

    public ExpensiveRunableTask() {
        this.id  = taskIdSupplier.incrementAndGet();
    }
    @Override
    public void run() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String name() {
        return String.format("expensive task # %s ", id).toString()  ;
    }

}
