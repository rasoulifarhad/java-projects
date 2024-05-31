package com.farhad.example.refactoring.gilded_rose_refactoring_kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        Item item = createAndUpdate(0, 0);
        assertEquals("foo", item.name);
    }

    @Test
    public void systemLowersValues() {

        Item item = createAndUpdate(15, 25);
        assertEquals(14, item.sellIn);
        assertEquals(24, item.quality);
    }

    @Test
    public void qualityDegradesTwiceAsFast() {
        Item item = createAndUpdate(0, 17);
        assertEquals(15, item.quality);
    }

    @Test
    public void qualityIsNeverNegative() {
        Item item = createAndUpdate(0, 0);
        assertEquals(0, item.quality);

    }

    private Item createAndUpdate(int sellIn, int quality) {
        Item[] items = new Item[] { new Item("foo", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0];
    }

}
