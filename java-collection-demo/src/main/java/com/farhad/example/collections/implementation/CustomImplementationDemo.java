package com.farhad.example.collections.implementation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomImplementationDemo {
    
    public void demonstrateMyList() {
        log.info("");
        Integer [] ints = {1, 2, 3, 4};
        List<Integer> listOfIntegers = MyList.asList(ints);

        log.info("MyLIst size: {}", listOfIntegers.size());
        System.out.print("MyList: [ ");
        listOfIntegers.forEach(i -> System.out.print(i + " "));
        System.out.println("]");


        List<Integer> tempList = MyList.asList(ints);
        Collections.shuffle(tempList);
        log.info("MyLIst shuffled: {}", tempList);
        Collections.sort(tempList);
        log.info("MyLIst sorted: {}", tempList);

        Object [] toArray = listOfIntegers.toArray();
        System.out.print("toArray: [ ");
        Stream.of(toArray)
            .forEach(o -> System.out.print(o + " "));
        System.out.println("]");
    }

    public static void main(String[] args) {
        CustomImplementationDemo demo = new CustomImplementationDemo();
        demo.demonstrateMyList();    
    }
}
