package com.farhad.example.solid_principles_and_design_patters.creational.factory_method;

public class ChartProviderPaid implements ChartProvider {

	@Override
	public Chart getChart() {
		Chart chart = new PieChart();
		return chart;
	}

}
