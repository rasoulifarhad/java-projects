package com.farhad.example.bridge;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Hammer implements Weapon {
    
    private final Enchantment enchantment;

    @Override
    public void weild() {
        log.info("The hammer is weilded.");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        log.info("Yhe hammer is swung.");
        enchantment.apply();
    }

    @Override
    public void unweild() {
        log.info("The hammer is unweilded.");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }

}
