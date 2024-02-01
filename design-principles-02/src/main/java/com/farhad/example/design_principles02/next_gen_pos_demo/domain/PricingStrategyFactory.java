package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

public class PricingStrategyFactory {

	private static PricingStrategyFactory pricingStrategyFactory;

	public static synchronized PricingStrategyFactory getInstance() {
		if (pricingStrategyFactory == null) {
			pricingStrategyFactory = new PricingStrategyFactory();
		}
		return pricingStrategyFactory;
	}

	public SalePricingStrategy getSalePricingStrategy() throws Exception {
		String clazzName = System.getProperty("salePricingStrategy.class.name");
		return (SalePricingStrategy) Class.forName(clazzName).newInstance();
	}

}
