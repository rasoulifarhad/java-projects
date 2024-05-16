package com.farhad.example.refactoring.production_plan;

import java.util.Arrays;

import com.farhad.example.refactoring.production_plan.Doc.DocProducer;

public class SampleProvinceData {

    public String getJson() {
        return
        "{" + 
        "    name: \"Asia\"," +
        "    producers: [" +
        "       {name: \"Byzantium\", cost: 10, production: 9}," +
        "       {name: \"Attalia\", cost: 12, production: 10}," +
        "       {name: \"Sinope\", cost: 10, production: 6}," +
        "    ]," +
        "    demand: 30," +
        "    price: 20" +
        "}";
    }

    public static Doc get() {
        return Doc.builder()
            .name("Asia")
            .demand(30)
            .price(20)
            .producers(Arrays.asList(
                    DocProducer.builder().name("Byzantium").cost(10).production(9).build(),
                    DocProducer.builder().name("Attalia").cost(12).production(10).build(),
                    DocProducer.builder().name("Sinope").cost(10).production(6).build()))
            .build();   
    }
}
