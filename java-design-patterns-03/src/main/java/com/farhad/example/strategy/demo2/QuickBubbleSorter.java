package com.farhad.example.strategy.demo2;

public class QuickBubbleSorter {
    
    private int operations;
    private int length = 0;
    private SortHandle itsSortHandle;
    
    public QuickBubbleSorter(SortHandle itsSortHandle) {
        this.itsSortHandle = itsSortHandle;
    }

    public int sort(Object array) {
        itsSortHandle.setArray(array);;
        length = itsSortHandle.lengrh();
        operations = 0;
        if(length <= 1) {
            return operations;
        }

        boolean thisPassInOrder = false;
        for (int nextToLast = length - 2 ; nextToLast >= 0 && !thisPassInOrder; nextToLast--) {
            thisPassInOrder = true;
            for (int index = 0; index < nextToLast; index++) {
                if(itsSortHandle.outOfOrder(index)) {
                    itsSortHandle.swap(index);
                    thisPassInOrder = false;
                }
                operations++;
            }
        }
        return operations;
    }
}
