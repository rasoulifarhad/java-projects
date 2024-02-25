package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.ocp.good;

public class App {

	public double calculateTax(IncomeDetails incomeDetails) {
		
		CountryTaxCalculator taxer = null;
		switch (incomeDetails.getCountry()) {
			case "US":
				taxer = new TaxCalculatorUS();
			    break;
			case "UK":
				taxer = new TaxCalculatorUk();
			    break;
			case "India":
				taxer = new TaxCalculatorIndia();
			    break;
		
			default:
				throw new IllegalArgumentException("Unknown country: " + incomeDetails.getCountry());
		}
		taxer.setTotalIncome(incomeDetails.getTotalIncome());
		taxer.setTotalDeduction(incomeDetails.getTotalDeduction());

		TaxCalculator taxCalculator = new TaxCalculator();
		return taxCalculator.calculate(taxer);
	}
}
