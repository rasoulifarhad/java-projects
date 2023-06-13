package com.farhad.example.models.generics;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Pair<L, R> {
    private final L left;
    private final R right;    
}
