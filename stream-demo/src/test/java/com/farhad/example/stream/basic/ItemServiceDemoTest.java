package com.farhad.example.stream.basic;

import static com.farhad.example.stream.basic.ItemServiceDemo.Support.service;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import com.farhad.example.stream.basic.ItemServiceDemo.Item;
import com.farhad.example.stream.basic.ItemServiceDemo.Support;;

public class ItemServiceDemoTest {

    @Test
    void testDoSomeThing() {
        final long idToFind = 6;
        final Predicate<Item> idFilter = (Item item) -> item.id().equals(idToFind);

        service().itemsMatching(idFilter)
                .findFirst()
                .ifPresent(Support::doSomething);
    }
}
