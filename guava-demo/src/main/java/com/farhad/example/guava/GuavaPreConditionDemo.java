package com.farhad.example.guava;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaPreConditionDemo {


    public void demonstrateDoSomethingOldWayNullList() {
        doSomethingOldWay(null);
    }

    public void demonstrateDoSomethingOldWayEmptyList() {
        doSomethingOldWay(new ArrayList<>());
    }
    public void demonstrateDoSomethingOldWay() {
        doSomethingOldWay(Arrays.asList("1", "2"));
    }

    public void demonstrateDoSomethingNullList() {
        doSomething(null);
    }
    
    public void demonstrateDoSomethingEmptyList() {
        doSomething(Collections.emptyList());
    }
    public void demonstrateDoSomething() {
        doSomething(Collections.singletonList("1"));
    }

    private void doSomethingOldWay(List<?> list) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty");
        }
        doSomethingMore(list);

    }

    private void doSomethingMore(List<?> list) {
        log.info("{}", list);
    }

    private void doSomething(List<?> list) {
        checkArgument( list != null, "List must not be null.");
        checkArgument(!list.isEmpty(), "List must not be empty");
        doSomethingMore(list);
    }

    public static void main(String[] args) {
        GuavaPreConditionDemo demo = new GuavaPreConditionDemo();

        try {
            demo.demonstrateDoSomethingOldWayNullList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            demo.demonstrateDoSomethingOldWayEmptyList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        demo.demonstrateDoSomethingOldWay();

        try {
            demo.demonstrateDoSomethingNullList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            demo.demonstrateDoSomethingEmptyList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        demo.demonstrateDoSomething();
    }
}
