package com.farhad.example.design_principles02.dessert.bad;

import com.farhad.example.design_principles02.dessert.bad.dessert.Cone;
import com.farhad.example.design_principles02.dessert.bad.dessert.Sundae;
import com.farhad.example.design_principles02.dessert.bad.icecream.IceCream;
import com.farhad.example.design_principles02.dessert.bad.topping.Syrup;
import com.farhad.example.design_principles02.dessert.bad.topping.Topping;

public class DessertCounter {

	public Cone orderCone(IceCream[] iceCreams, Topping[] toppings) {
		Cone cone = new Cone();
		for (IceCream iceCream : iceCreams) {
			cone.addScoop(iceCream);
		}

		for (Topping topping : toppings) {
			cone.addTopping(topping);
		}
		return cone;
	}
	
	public Sundae orderSundae(IceCream[] iceCreams, Topping[] toppings, Syrup[] syrups) {
		Sundae sundae = new Sundae();

		for (IceCream iceCream : iceCreams) {
			sundae.addScoop(iceCream);
		}

		for (Topping topping : toppings) {
			sundae.addTopping(topping);
		}

		for (Syrup syrup : syrups) {
			sundae.addSyrup(syrup);
		}

		return sundae;
	}

	public Cone addTopping(Cone cone, Topping topping) {
		cone.addTopping(topping);
		return cone;
	}

	public Sundae addTopping(Sundae sundae, Topping topping) {
		sundae.addTopping(topping);
		return sundae;
	}
}
