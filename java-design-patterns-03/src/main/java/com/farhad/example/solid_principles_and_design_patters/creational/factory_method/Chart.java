package com.farhad.example.solid_principles_and_design_patters.creational.factory_method;

import java.util.List;

public interface Chart {

	String getTitle();

	void setTitle(String title);

	List<String> getXData();

	List<Integer> getYData();

	void setXData(List<String> xdata);

	void setYData(List<Integer> ydata);

	BitMap generateChart();
}
