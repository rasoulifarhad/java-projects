package com.farhad.example.refactoring.gilded_rose_refactoring_kata;

class GildedRose {

    static final int BACKSTAGE_PASSES_THRESHOLD1 = 11;
    static final int BACKSTAGE_PASSES_THRESHOLD2 = 6;
    static final int MAXIMUM_QUALITY = 50;
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String AGED_BRIE = "Aged Brie";
    static final String CONJURED = "Conjured";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(items[i]);
        }
    }

    private void updateItemQuality(Item item) {
        handleIfNormalItem(item);
        handleIfAgedBrieItem(item);
        handleIfBackstagePassesItem(item);
        handleIfSulfurasItem(item);
        handleIfConjuredItem(item);
    }

    private void handleIfConjuredItem(Item item) {
        if(isConjuredItem(item)) {
            item.sellIn--;
            item.quality -= 2;
        }
    }

    private void handleIfSulfurasItem(Item item) {
        if (isSulfuras(item)) {

        }
    }

    private void handleIfBackstagePassesItem(Item item) {

        if (isBackstagePasses(item)) {

            if (item.quality < MAXIMUM_QUALITY) {
                item.quality++;

                if (item.sellIn < BACKSTAGE_PASSES_THRESHOLD1) {
                    if (item.quality < MAXIMUM_QUALITY) {
                        item.quality++;
                    }
                }

                if (item.sellIn < BACKSTAGE_PASSES_THRESHOLD2) {
                    if (item.quality < MAXIMUM_QUALITY) {
                        item.quality++;
                    }
                }
            }

            item.sellIn--;

            if (item.sellIn < 0) {
                item.quality = 0;
            }
        }
    }

    private void handleIfAgedBrieItem(Item item) {
        if (isAgedBrie(item)) {
            if (item.quality < MAXIMUM_QUALITY) {
                item.quality++;
            }
            item.sellIn--;

            if (item.sellIn < 0) {
                if (item.quality < MAXIMUM_QUALITY) {
                    item.quality++;
                }
            }
        }
    }

    private void handleIfNormalItem(Item item) {
        if (isNormalItem(item)) {
            if (item.sellIn == 0) {
                item.quality -= 2;
            } else {
                item.quality--;
            }
            item.sellIn--;

            if (item.quality < 0) {
                item.quality = 0;
            }
        }
    }

    private boolean isNormalItem(Item item) {
        return !(isAgedBrie(item) || isBackstagePasses(item) || isSulfuras(item) || isConjuredItem(item));
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private boolean isConjuredItem(Item item) {
        return item.name.equals(CONJURED);
    }

}
