package com.farhad.example.refactoring.gilded_rose_refactoring_kata;

class GildedRose {

    static final int BACKSTAGE_PASSES_THRESHOLD1 = 11;
    static final int BACKSTAGE_PASSES_THRESHOLD2 = 6;

    static final int MAXIMUM_QUALITY = 50;

    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (!isAgedBrie(item)
                    && !isBackstagePasses(item)) {
                if (item.quality > 0) {
                    if (!isSulfuras(item)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < MAXIMUM_QUALITY) {
                    item.quality = item.quality + 1;

                    if (isBackstagePasses(item)) {
                        if (item.sellIn < BACKSTAGE_PASSES_THRESHOLD1) {
                            if (item.quality < MAXIMUM_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < BACKSTAGE_PASSES_THRESHOLD2) {
                            if (item.quality < MAXIMUM_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(item)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePasses(item)) {
                        if (item.quality > 0) {
                            if (!isSulfuras(item)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < MAXIMUM_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
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
}
