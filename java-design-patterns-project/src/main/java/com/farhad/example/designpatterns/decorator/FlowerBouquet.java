package com.farhad.example.designpatterns.decorator;

import lombok.Getter;

/**
 * See https://dzone.com/articles/the-decorator-pattern
 */
@Getter
public abstract class FlowerBouquet {
    
    String description;

    public abstract double cost();

}
