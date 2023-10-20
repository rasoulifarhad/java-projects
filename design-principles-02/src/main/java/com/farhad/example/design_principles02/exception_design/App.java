package com.farhad.example.design_principles02.exception_design;

public class App {
	

	public static void main(String[] args) {

		OrderService orderService = new OrderService();
		ExceptionHandler exceptionHandler = new ExceptionHandler();
		Order order = orderService.getOrderOfId(Long.valueOf(1));
		System.out.println(order);

		try {
			orderService.getOrderOfId(Long.valueOf(-1));
		} catch (BusinessException e) {
			ErrorResult errorResult = exceptionHandler.handel(e);
			System.out.println(errorResult);
		}
	}
}
