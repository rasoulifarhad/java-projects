package com.farhad.example.prototype;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    
    public static void main(String[] args) {
        HeroFactory heroFactory;
        Mage mage;
        Beast beast;
        Warlord warlord;
        
        heroFactory = new HeroFactoryImpl(new ElfMage(), new ElfWarlord(), new ElfBeast());
        mage = heroFactory.createMage();
        warlord = heroFactory.createWarlord();
        beast = heroFactory.createBeast();
        log.info(mage.toString());
        log.info(warlord.toString());
        log.info(beast.toString());

        heroFactory = new HeroFactoryImpl(new OrcMage(), new OrcWarlord(), new OrcBeast());
        mage = heroFactory.createMage();
        warlord = heroFactory.createWarlord();
        beast = heroFactory.createBeast();
        log.info(mage.toString());
        log.info(warlord.toString());
        log.info(beast.toString());

    }
}
