package com.farhad.example.codekata.horse_kata;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PaginatedTable {

    private final List<String> headers;
    private final List<List<String>> tableData;
    private final int totalRows;

}
