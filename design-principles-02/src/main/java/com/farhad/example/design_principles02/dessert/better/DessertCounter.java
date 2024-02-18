package com.farhad.example.design_principles02.dessert.better;

import com.farhad.example.design_principles02.dessert.better.dessert.Cone;
import com.farhad.example.design_principles02.dessert.better.dessert.Dessert;
import com.farhad.example.design_principles02.dessert.better.dessert.Sundae;
import com.farhad.example.design_principles02.dessert.better.icecream.IceCream;
import com.farhad.example.design_principles02.dessert.better.topping.Topping;

// - DessertCounter is coding to implementation of Dessert interface, we can reduce orderCone and orderSundae to orderDessert
// - DessertConter has more than one reason to change: if the ordering process changes, or if how the Cone and Sundae class adds toppings 
//   changes.adding a topping should be done to the Dessert class es directly.
// - Syrup is an implementation of topping. we do'nt need  a methodto to add a syrup  in Sundae class (coding to an implementation)
// - there are a LOT of serve() implementations . we should try an encapsulate what varies, and put all the serving code in one place.
public class DessertCounter {

	enum DessertType {
		CONE, SUNDAE
	}

	public Dessert orderDessert(DessertType dessertType, IceCream[] iceCreams, Topping[] toppings) {
		Dessert dessert = getDessert(dessertType);

		for (IceCream iceCream : iceCreams) {
			dessert.addIceCream(iceCream);
		}

		for (Topping topping : toppings) {
			dessert.addTopping(topping);
		}
		return dessert;
		
	}

	public Dessert getDessert(DessertType dessertType) {

		if (dessertType.equals(DessertType.CONE)) {
			return new Cone();
		} else if (dessertType.equals(DessertType.SUNDAE)) {
			return new Sundae();
		}
		throw new IllegalArgumentException("Unknown dessert type");
	}


}
