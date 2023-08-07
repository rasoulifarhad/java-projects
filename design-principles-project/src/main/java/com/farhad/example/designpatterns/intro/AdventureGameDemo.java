package com.farhad.example.designpatterns.intro;

// See [O`Reilly. Head First] - Head First Design Patterns - [Freeman] 
// Each character can make use of one weapon at a time, but can change weapons at any time during the game.
public class AdventureGameDemo {
	
	
	static class Character {

		protected WeaponBehavior weapon;

		public Character(WeaponBehavior weaponBehavior) {
			this.weapon = weaponBehavior;
		}

		public void fight() {
			System.out.println("Fighting......");
		}

		public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
			this.weapon = weaponBehavior;
		}

	}

	interface WeaponBehavior {
		void useWeapon();
	}

	static class Queen extends Character {

		public Queen(WeaponBehavior weaponBehavior) {
			super(weaponBehavior);
		}

		@Override
		public void fight() {
			System.out.println("Queen fithing: weapon " + weapon);
		} 
	}

	static class King extends Character {

		public King(WeaponBehavior weaponBehavior) {
			super(weaponBehavior);
		}

		@Override
		public void fight() {
			System.out.println("King fithing: weapon " + weapon);
		}
	}

	static class Knight extends Character {

		public Knight(WeaponBehavior weaponBehavior) {
			super(weaponBehavior);
		}

		@Override
		public void fight() {		
			System.out.println("Knight fithing: weapon " + weapon);
		}
	}

	static class Troll extends Character {

		public Troll(WeaponBehavior weaponBehavior) {
			super(weaponBehavior);
		}

		@Override
		public void fight() {
			System.out.println("Troll fithing: " + weapon);
		}

	}

	static class SwordBehavior implements WeaponBehavior {

		@Override
		public void useWeapon() {
			System.out.println("Useing sword weapon. ");
		}

		public String toString() {
			return "Useing sword weapon. ";
		}
	
	}

	static class AxeBehavior implements WeaponBehavior {

		@Override
		public void useWeapon() {
			System.out.println("Useing axe weapon. ");
		}
		
		public String toString() {
			return "Useing axe weapon. ";
		}
	}

	static class KnifeBehavior implements WeaponBehavior {

		@Override
		public void useWeapon() {
			System.out.println("Useing knife weapon. ");
		}

		public String toString() {
			return "Useing knife weapon. ";
		}
		
	}

	static class BowAndArrowBehavior implements WeaponBehavior {

		@Override
		public void useWeapon() {
			System.out.println("Useing Bow and Arrow weapon. ");
		}

		public String toString() {
			return "Useing Bow and Arrow weapon. ";
		}
		
	}
}
