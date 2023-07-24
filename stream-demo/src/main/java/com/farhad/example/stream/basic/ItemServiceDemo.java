package com.farhad.example.stream.basic;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ItemServiceDemo {
    
    public static class Item {
        private final Long id;
        private final String name;
        public Item(final long id, final String name) {
            this.id = id;
            this.name = name;
        }

        public Long id() {
            return id;
        }

        public String name() {
            return name;
        }
        
    }

    public static class ItemService {

        public List<Item> allItems() {
            final List<Item> list = IntStream.range(0, 20)
                                             .mapToObj(i -> item(i, "Item " + i))
                                             .collect(collectingAndThen(toList(), ItemService::addDuplicate));
            Collections.shuffle(list);
            return Collections.unmodifiableList(list);
        }
        public Stream<Item> itemsMatching(final Predicate<Item> filter) {
            return allItems().stream() 
                        .filter(filter);
        }

        private static List<Item> addDuplicate(final List<Item> items) {
            final List<Item> list = IntStream.range(0, 10)
                                             .mapToObj(i -> item(i, "Item " + i))
                                             .collect(toList());
            items.addAll(list);
            return items;       
        }

        private static Item item(final long id, final String name) {
            return new Item(id, name);
        }
    }

    static class Support {
        public static ItemService service() {
            return new ItemService();
        }

        public static void doSomething(final Item item) {
            System.out.println("Processing item: [" + item.id + ":" + item.name + "]");
        }
    }
}
