package com.farhad.example.design_principles02.solidprinciples_and_designpatterns.ocp.good;

public class TaxCalculatorUS implements  CountryTaxCalculator {

	private double totalIncome;
	private double totalDeduction;

	@Override
	public double calculateTaxAmount() {
		double taxableIncom = getTotalIncome() - getTotalDeduction();
		return taxableIncom * 30 / 100;
	}

	@Override
	public void setTotalIncome(double amount) {
		this.totalIncome = amount;
	}

	@Override
	public void setTotalDeduction(double deduction) {
		this.totalDeduction = deduction;
	}

	@Override
	public double getTotalIncome() {
		return totalIncome;
	}

	@Override
	public double getTotalDeduction() {
		return totalDeduction;
	}

}
