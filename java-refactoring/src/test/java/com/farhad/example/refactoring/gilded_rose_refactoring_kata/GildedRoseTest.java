package com.farhad.example.refactoring.gilded_rose_refactoring_kata;

import static com.farhad.example.refactoring.gilded_rose_refactoring_kata.GildedRose.AGED_BRIE;
import static com.farhad.example.refactoring.gilded_rose_refactoring_kata.GildedRose.BACKSTAGE_PASSES;
import static com.farhad.example.refactoring.gilded_rose_refactoring_kata.GildedRose.CONJURED;
import static com.farhad.example.refactoring.gilded_rose_refactoring_kata.GildedRose.MAXIMUM_QUALITY;
import static com.farhad.example.refactoring.gilded_rose_refactoring_kata.GildedRose.SULFURAS;
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
        Item item = createAndUpdate(AGED_BRIE, 15, 25);
        assertEquals(26, item.quality);
    }

    @Test
    public void qualityNeverMoreThanMaximum() {
        Item item = createAndUpdate("foo", 15, 52);
        assertEquals(51, item.quality);

        item = createAndUpdate(AGED_BRIE, 15, MAXIMUM_QUALITY);
        assertEquals(50, item.quality);
    }

    @Test
    public void sulfurasNeverHasToBeSoldOrDecreasesInQuality() {
        Item item = createAndUpdate(SULFURAS, 1, 42);
        assertEquals(1, item.sellIn);
        assertEquals(42, item.quality);
    }

    @Test
    public void backstagePassesIncreasesInQuality() {
        Item item = createAndUpdate(BACKSTAGE_PASSES, 15, 25);
        assertEquals(26, item.quality);
    }

    @Test
    public void backstagePassesIncreasesInQualityBy2() {
        Item item = createAndUpdate(BACKSTAGE_PASSES, 10, 25);
        assertEquals(27, item.quality);
    }

    @Test
    public void backstagePassesIncreasesInQualityBy3() {
        Item item = createAndUpdate(BACKSTAGE_PASSES, 5, 25);
        assertEquals(28, item.quality);
    }

    @Test
    public void backstagePassesQualityDropTo0() {
        Item item = createAndUpdate(BACKSTAGE_PASSES, 0, 25);
        assertEquals(0, item.quality);
    }

    @Test
    public void agedBrieNeverExpires() {
        Item item = createAndUpdate(AGED_BRIE, 0, 42);
        assertEquals(-1, item.sellIn);
        assertEquals(44, item.quality);
    }

    @Test
    public void agedBrieSellInNegative() {
        Item item = createAndUpdate(AGED_BRIE, -1, 42);
        assertEquals(44, item.quality);
    }

    @Test
    public void backstagePassMaximumQuality() {
        Item item = createAndUpdate(BACKSTAGE_PASSES, 10, 48);
        assertEquals(MAXIMUM_QUALITY, item.quality);

        item = createAndUpdate(BACKSTAGE_PASSES, 10, 49);
        assertEquals(MAXIMUM_QUALITY, item.quality);

        item = createAndUpdate(BACKSTAGE_PASSES, 5, 49);
        assertEquals(MAXIMUM_QUALITY, item.quality);
    }

    @Test
    public void agedBrieMaximumQuality() {
        Item item = createAndUpdate(AGED_BRIE, -1, 49);
        assertEquals(MAXIMUM_QUALITY, item.quality);
    }

    @Test
    void degradeInQualityUnlessSulfuras() {
        Item item = createAndUpdate("foo", -1, 1);
        assertEquals(0, item.quality);

        item = createAndUpdate(SULFURAS, -1, 1);
        assertEquals(1, item.quality);
    }

    @Test
    public void conjuredDegradeTwiceAsFast() {
        Item item = createAndUpdate(CONJURED, 15, 25);
        assertEquals(23, item.quality);
    }

}
