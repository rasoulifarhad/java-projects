package com.farhad.example.collections.implementation;

import java.util.AbstractList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyList<T> extends AbstractList<T>{

    private final T [] backedArray; 
    @Override
    public int size() {
        return backedArray.length;
    }

    @Override
    public Object[] toArray() {
        return (Object[]) backedArray.clone();
    }

    @Override
    public T set(int index, T element) {
        T oldValue = backedArray[index];
        backedArray[index] = element;
        return oldValue;
    }

    @Override
    public T get(int index) {
        return backedArray[index];
    }

    public static <T> List<T> asList(T [] array) {
        return new MyList<>(array);
    }
    
}
