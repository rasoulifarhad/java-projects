package com.farhad.example.design_principles02.dessert.bad.dessert;

import java.util.ArrayList;
import java.util.List;

import com.farhad.example.design_principles02.dessert.bad.icecream.IceCream;
import com.farhad.example.design_principles02.dessert.bad.topping.Syrup;
import com.farhad.example.design_principles02.dessert.bad.topping.Topping;

import lombok.Getter;

@Getter
public class Sundae extends Dessert {

	private List<IceCream> iceCreams;
	private List<Syrup> syrups;
	private List<Topping> toppings;

	
	public Sundae() {
		iceCreams = new ArrayList<>();
		syrups = new ArrayList<>();
		toppings = new ArrayList<>();
	}

	public void addScoop(IceCream iceCream) {
		iceCreams.add(iceCream);
	}

	public void addSyrup(Syrup syrup) {
		syrups.add(syrup);
	}

	public void addTopping(Topping topping) {
		toppings.add(topping);
	}

}
