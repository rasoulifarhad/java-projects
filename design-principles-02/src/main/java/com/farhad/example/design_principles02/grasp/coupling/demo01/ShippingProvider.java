package com.farhad.example.design_principles02.grasp.coupling.demo01;

// Instead of having a direct dependency between the Order class and the ShippingService class, we can introduce an interface, 
// ShippingProvider, which reduces coupling and allows for easier substitution of shipping services.
public interface ShippingProvider {

	void ship(Order order);
}
