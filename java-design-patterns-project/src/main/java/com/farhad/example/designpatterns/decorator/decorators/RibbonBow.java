package com.farhad.example.designpatterns.decorator.decorators;

import com.farhad.example.designpatterns.decorator.FlowerBouquet;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RibbonBow extends FlowerBouquetDecorator {
    
    final FlowerBouquet flowerBouquet ;

    @Override
    public String getDescription() {
        return flowerBouquet.getDescription() + ", ribbon bow";
    }

    @Override
    public double cost() {
        return 6.5 + flowerBouquet.cost();
    }

}
