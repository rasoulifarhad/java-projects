package com.farhad.example.designpatterns.factory.weapondemo;

public class WeaponDemo {
    
    public static void main(String[] args) {
        Weapon gun = WeaponFactory.createWeapon("Gun");
        gun.use();    
    }

        interface Weapon {
        void use();
    }

    static class WeaponFactory {

        public static Weapon createWeapon(String weaponType) {
            if ("Gun".equals(weaponType) ) {
                return new Gun();
            }
            if ("Crossbow".equals(weaponType)) {
                return new Crossbow();
            }
            throw new IllegalArgumentException("Weapon type not supported: " + weaponType);
        }
    }

    static class Gun implements Weapon {

        @Override
        public void use() {
            System.out.println("Using gun.....");
        }
    }

    static class Crossbow implements Weapon {

        @Override
        public void use() {
            System.out.println("Using crossbow.....");
        }
    }
}
