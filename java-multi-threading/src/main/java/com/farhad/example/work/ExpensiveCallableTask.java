package com.farhad.example.work;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class ExpensiveCallableTask implements CallableTask {

    private static final AtomicInteger taskIdSupplier = new AtomicInteger(0);

    private final int  id ;

    public ExpensiveCallableTask() {
        this.id  = taskIdSupplier.incrementAndGet();
    }

    @Override
    public String name() {
        return String.format("expensive task # %s ", id).toString()  ;
    }
    @Override
    public CalcResult call() throws Exception {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CalcResult.of(ThreadLocalRandom.current().nextDouble() * 100 );
    }
    
}
