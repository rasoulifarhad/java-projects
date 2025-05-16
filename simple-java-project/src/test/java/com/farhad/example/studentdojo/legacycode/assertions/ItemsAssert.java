package com.farhad.example.studentdojo.legacycode.assertions;

import static org.assertj.core.api.Assertions.extractProperty;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractIterableAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;

import com.farhad.example.studentdojo.legacycode.Item;
import com.farhad.example.studentdojo.legacycode.assertions.ItemsAssert.ItemAssert;

public class ItemsAssert extends AbstractIterableAssert<ItemsAssert, Iterable<Item>, Item, ItemAssert> {

    protected ItemsAssert(Iterable<Item> actual) {
        super(actual, ItemsAssert.class);
    }
    
    protected ItemsAssert(Iterable<Item> actual, Class<?> selfType) {
        super(actual, selfType);
    }

    public static ItemsAssert assertThat(Iterable<Item> actual) {
        return new ItemsAssert(actual);
    }

    public ItemsAssert containsOnlyItemNames(String... names) {
        isNotNull();

        Iterable<String> actualItemNames = extractProperty("name", String.class)
                .from(actual);

        Assertions
                .assertThat(actualItemNames)
                .containsOnly(names);

        return this;
    }

    public ItemsAssert containsOnlyItemQualities(Integer... qualities) {
        isNotNull();

        Iterable<Integer> actualItemQualities = extractProperty("quality", Integer.class)
                .from(actual);
        Assertions.assertThat(actualItemQualities).containsOnly(qualities);

        return this;
    }

    public ItemsAssert containsOnlyItemSellIns(Integer... sellIns) {
        isNotNull();

        Iterable<Integer> actualItemSellIns = extractProperty("sellIn", Integer.class)
                .from(actual);
        Assertions.assertThat(actualItemSellIns).containsOnly(sellIns);

        return this;
    }


    public static class ItemAssert extends AbstractAssert<ItemAssert, Item> {

        public ItemAssert(Item entity, Class<?> selfType) {
            super(entity, selfType);
        }
    }


    @Override
    protected ItemAssert toAssert(Item value, String description) {
        return new ItemAssert(value, ItemAssert.class);
    }

    @Override
    protected ItemsAssert newAbstractIterableAssert(Iterable<? extends Item> iterable) {
        return new ItemsAssert(Lists.newArrayList(iterable));
    }    
}