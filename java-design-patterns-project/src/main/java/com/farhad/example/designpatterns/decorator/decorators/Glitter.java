package com.farhad.example.designpatterns.decorator.decorators;

import com.farhad.example.designpatterns.decorator.FlowerBouquet;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Glitter extends FlowerBouquetDecorator {
    
    final FlowerBouquet flowerBouquet ;

    @Override
    public String getDescription() {
        return flowerBouquet.getDescription() + ", glitter";
    }

    @Override
    public double cost() {
        return 4 + flowerBouquet.cost();
    }

}
