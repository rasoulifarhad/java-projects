package com.farhad.example.design_principles02.exception_design;

public class OrderService {
	

	public Order getOrderOfId(Long id) {
		if (id == null) {
			throw new BusinessException( OrderException.ORDER_ID_IS_NULL);
		}
		if (id < 0 ) {
			throw new BusinessException( OrderException.ORDER_NOT_FOUNT);
		}
		return new Order(id);

	}
}
