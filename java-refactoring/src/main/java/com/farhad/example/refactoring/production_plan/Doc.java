package com.farhad.example.refactoring.production_plan;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
public class Doc {

    public String name;
    public int demand;
    public int price;
    public List<DocProducer> producers;

    @Getter
    @AllArgsConstructor
    @Builder
    public static class DocProducer {
        private String name;
        private int cost;
        private Integer production;
    }
}
