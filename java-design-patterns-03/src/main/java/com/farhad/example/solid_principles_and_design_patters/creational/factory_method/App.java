package com.farhad.example.solid_principles_and_design_patters.creational.factory_method;

import java.util.ArrayList;
import java.util.List;

public class App {

	public void chartImageFree() {
		ChartProviderFree cp = new ChartProviderFree();
		Chart chart = cp.getChart();

		chart.setTitle("Hours per day");

		List<String> xdata = new ArrayList<>();
		xdata.add("Mon");
		xdata.add("Tue");
		xdata.add("Wen");
		xdata.add("Thu");
		xdata.add("Fri");
		xdata.add("Sat");
		xdata.add("Sun");

		List<Integer> ydata = new ArrayList<>();
		ydata.add(12);
		ydata.add(7);
		ydata.add(4);
		ydata.add(10);
		ydata.add(	3);
		ydata.add(5);

		chart.setXData(xdata);
		chart.setYData(ydata);

		BitMap bitMap = chart.generateChart();
	}
}
