package com.farhad.example.prototype;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HeroFactoryImpl implements HeroFactory {

    private Mage mage;
    private Warlord warlord;
    private Beast beast;

    @Override
    public Mage createMage() {
        try {
            return mage.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public Warlord createWarlord() {
        try {
            return warlord.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public Beast createBeast() {
        try {
            return beast.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
}
