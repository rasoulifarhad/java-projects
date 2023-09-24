package com.farhad.example.value_object;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    
    public static void main(String[] args) {
      HeroStat heroStat1 = HeroStat.valueOf(10, 20, 30);
      HeroStat heroStat2 = HeroStat.valueOf(10, 20, 30);
      HeroStat heroStat3 = HeroStat.valueOf(5, 10, 15);

      log.info(heroStat1.toString());
      log.info("Is heroStat1 and heroStat2 equal: {}", heroStat1.equals(heroStat2));
      log.info("Is heroStat1 and heroStat3 equal: {}", heroStat1.equals(heroStat3));
    }
}
