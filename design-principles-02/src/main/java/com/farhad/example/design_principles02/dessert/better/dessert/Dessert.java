package com.farhad.example.design_principles02.dessert.better.dessert;

import com.farhad.example.design_principles02.dessert.better.icecream.IceCream;
import com.farhad.example.design_principles02.dessert.better.topping.Topping;

public interface Dessert {
	void serve();

	void addIceCream(IceCream iceCream);

	void addTopping(Topping topping);
}
