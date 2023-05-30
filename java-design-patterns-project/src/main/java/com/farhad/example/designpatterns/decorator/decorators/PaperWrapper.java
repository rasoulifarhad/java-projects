package com.farhad.example.designpatterns.decorator.decorators;

import com.farhad.example.designpatterns.decorator.FlowerBouquet;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaperWrapper extends FlowerBouquetDecorator {

    final FlowerBouquet flowerBouquet ;

    @Override
    public String getDescription() {
        return flowerBouquet.getDescription() + ", paper wrapped";
    }

    @Override
    public double cost() {
        return 3 + flowerBouquet.cost();
    }

}
