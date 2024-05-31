package com.farhad.example.refactoring.gilded_rose_refactoring_kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    private Item createAndUpdate(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0];
    }
    
    @Test
    void foo() {
        Item item = createAndUpdate("foo", 0, 0);
        assertEquals("foo", item.name);
    }

    @Test
    public void systemLowersValues() {

        Item item = createAndUpdate("foo", 15, 25);
        assertEquals(14, item.sellIn);
        assertEquals(24, item.quality);
    }

    @Test
    public void qualityDegradesTwiceAsFast() {
        Item item = createAndUpdate("foo", 0, 17);
        assertEquals(15, item.quality);
    }

    @Test
    public void qualityIsNeverNegative() {
        Item item = createAndUpdate("foo", 0, 0);
        assertEquals(0, item.quality);
    }

    @Test
    public void agedBrieIncreaseInQuality() {
        Item item = createAndUpdate("Aged Brie", 15, 25);
        assertEquals(26, item.quality);
    }

    @Test
    public void qualityNeverMoreThan50() {
        Item item = createAndUpdate("foo", 15, 52);
        assertEquals(51, item.quality);

        item = createAndUpdate("Aged Brie", 15, 50);
        assertEquals(50, item.quality);
    }
    
    @Test
    public void sulfurasNeverHasToBeSoldOrDecreasesInQuality() {
        Item item = createAndUpdate("Sulfuras, Hand of Ragnaros", 1, 42);
        assertEquals(1, item.sellIn);
        assertEquals(42, item.quality);
    }

}
