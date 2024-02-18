package com.farhad.example.design_principles02.dessert.bad.dessert;

import java.util.ArrayList;
import java.util.List;

import com.farhad.example.design_principles02.dessert.bad.icecream.IceCream;
import com.farhad.example.design_principles02.dessert.bad.topping.Topping;

import lombok.Getter;

@Getter
public class Cone extends Dessert {

	private List<IceCream> iceCreams;
	private List<Topping> toppings;

	
	public Cone() {
		iceCreams = new ArrayList<>();
		toppings = new ArrayList<>();
	}

	public void addScoop(IceCream iceCream) {
		iceCreams.add(iceCream);
	}

	public void addTopping(Topping topping) {
		toppings.add(topping);
	}

}
