package com.farhad.example.completable_future.demo02;

public class CategorizationService {
    
    public Category categirizeTransaction(Transaction tx ) {
        delay();
        return new Category("Categiry_" + tx.getId());
    }

    private void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
