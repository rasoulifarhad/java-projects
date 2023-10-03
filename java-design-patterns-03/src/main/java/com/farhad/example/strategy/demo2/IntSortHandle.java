package com.farhad.example.strategy.demo2;

public class IntSortHandle implements SortHandle{

    int[] array = null;

    @Override
    public int lengrh() {
        return array.length;
    }

    @Override
    public void setArray(Object array) {
        this.array = (int[]) array;
    }

    @Override
    public boolean outOfOrder(int index) {
        return array[index] > array[index + 1];
    }

    @Override
    public void swap(int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1 ] = temp;
    }
    
}
