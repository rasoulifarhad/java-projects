package com.farhad.example.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    
    public static void main(String[] args) {
    
        log.info("The knight receives an enchanted sword.");  
        Weapon enchantedSword = new Sword(new SoulEatingEnchantment())      ;
        enchantedSword.weild();
        enchantedSword.swing();
        enchantedSword.unweild();

        log.info("The valkyrie receives an enchanted hammer.");        
        Weapon hammer = new Hammer(new FlyingEnchantment());
        hammer.weild();
        hammer.swing();
        hammer.unweild();
    }
}
