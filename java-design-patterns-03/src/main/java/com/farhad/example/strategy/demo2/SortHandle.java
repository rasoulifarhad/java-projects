package com.farhad.example.strategy.demo2;

public interface SortHandle {

    int lengrh();

    void setArray(Object array);

    boolean outOfOrder(int index);

    void swap(int index);
    
}
