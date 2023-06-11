package com.farhad.example.models.generics;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Triplet<L, M, R> {
    private final L left;
    private final M middle;
    private final R right;
}
