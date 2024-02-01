package com.farhad.example.design_principles02.next_gen_pos_demo.domain;

public class PricingStrategyFactory {

	private static PricingStrategyFactory pricingStrategyFactory;

	public static synchronized PricingStrategyFactory getInstance() {
		if (pricingStrategyFactory == null) {
			pricingStrategyFactory = new PricingStrategyFactory();
		}
		return pricingStrategyFactory;
	}

	// public SalePricingStrategy getSalePricingStrategy() throws Exception {
	// 	String clazzName = System.getProperty("salePricingStrategy.class.name");
	// 	return (SalePricingStrategy) Class.forName(clazzName).newInstance();
	// }

	public SalePricingStrategy getSalePricingStrategy() throws Exception {
		CompositeBestForCustomerPricingStrategy ps = new CompositeBestForCustomerPricingStrategy();
		PercentDiscountPricingStrategy percentDiscountPricingStrategy = new PercentDiscountPricingStrategy(0.1);
		ps.add(percentDiscountPricingStrategy);
		return ps;
	}


	public void addCustomerPricingStrategy(Sale sale) {
		Customer c = sale.getCustomer();
		SalePricingStrategy ps = sale.getPricingStrategy();
		double pct = getCustomerPerecentage(c);
		PercentDiscountPricingStrategy percentDiscountPricingStrategy = new PercentDiscountPricingStrategy(pct);
		((CompositePricingStrategy)ps).add(percentDiscountPricingStrategy);
	}

	private double getCustomerPerecentage(Customer c) {
		return 0.15;
	}

}
