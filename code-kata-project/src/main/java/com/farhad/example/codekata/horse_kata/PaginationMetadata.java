package com.farhad.example.codekata.horse_kata;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PaginationMetadata {

    private final int firstRecordInPage;
    private final int pageSize;
}
