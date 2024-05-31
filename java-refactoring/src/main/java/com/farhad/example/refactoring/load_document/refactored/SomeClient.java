package com.farhad.example.refactoring.load_document.refactored;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class SomeClient {

    public List<String> doSomething(Assortment assortment) {
        List<String> titles = assortment.getAlbums()
            .stream()
                .map(a -> a.getTitle())
                .collect(toList());
        return somethingCleverWith(titles);
    }

    private List<String> somethingCleverWith(List<String> titles) {
        return titles;
    }
}
