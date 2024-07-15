package com.farhad.example.codekata.horse_kata;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

public class Horse {

    public static PaginatedTable filterSortPaginateTable(
        List<String> headers,
        List<List<Object>> tableData,
        List<FilterMetadata> filters,
        Optional<SortMetadata> maybeSortMetadata,
        PaginationMetadata paginationMetadata) {
                  
        // TODO: filter horse table using filters

        // TODO: sort horse table using sortMetadata

        // TODO: paginate horse table using paginationMetadata

        // Map all the data to Strings for the front end
        List<List<String>> tableDataAsStrings = tableData.stream()
            .map(row -> row.stream()
                .map(Object::toString)
                .collect(toList())
            )
            .collect(toList());
        return new PaginatedTable(headers, tableDataAsStrings, tableData.size());
    }
}
