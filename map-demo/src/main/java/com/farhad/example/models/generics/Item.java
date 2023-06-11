package com.farhad.example.models.generics;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Item<T> {
    private final T value;
}
