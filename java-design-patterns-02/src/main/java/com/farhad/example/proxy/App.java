package com.farhad.example.proxy;

public class App {
	
	public static void main(String[] args) {
		
		WizardTowerProxy proxy = new WizardTowerProxy(new IvoryTower());
		proxy.enter(new Wizard("REd wizard"));
		proxy.enter(new Wizard("White wizard"));
		proxy.enter(new Wizard("Black wizard"));
		proxy.enter(new Wizard("Green wizard"));
		proxy.enter(new Wizard("Brown wizard"));
	}
}
