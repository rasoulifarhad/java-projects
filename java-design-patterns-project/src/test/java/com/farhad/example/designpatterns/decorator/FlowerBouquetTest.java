package com.farhad.example.designpatterns.decorator;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.decorator.decorators.Glitter;
import com.farhad.example.designpatterns.decorator.decorators.PaperWrapper;
import com.farhad.example.designpatterns.decorator.decorators.RibbonBow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlowerBouquetTest {
    
    @Test
    public void flowerBouquetTest() {

        FlowerBouquet roseBouquet = new RoseBouquet();
        log.info("{}  ${}", roseBouquet.getDescription(), roseBouquet.cost());

        FlowerBouquet decoratedRoseBouquet = new RoseBouquet();
        decoratedRoseBouquet = new PaperWrapper(decoratedRoseBouquet);
        decoratedRoseBouquet = new RibbonBow(decoratedRoseBouquet);
        decoratedRoseBouquet = new Glitter(decoratedRoseBouquet);
        log.info("{}  ${}", decoratedRoseBouquet.getDescription(), decoratedRoseBouquet.cost());


        FlowerBouquet decoratedOrchidBouquet = new OrchidBouquet();
        decoratedOrchidBouquet = new PaperWrapper(decoratedOrchidBouquet);
        decoratedOrchidBouquet = new RibbonBow(decoratedOrchidBouquet);
        decoratedOrchidBouquet = new Glitter(decoratedOrchidBouquet);
        log.info("{}  ${}", decoratedOrchidBouquet.getDescription(), decoratedOrchidBouquet.cost());
    }

    
}
