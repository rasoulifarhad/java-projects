package com.farhad.example.models.cyclic;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Node<T> {
    private final Node<T> next;
    private final T value;

}
