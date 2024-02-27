package com.farhad.example.solid_principles_and_design_patters.creational.factory_method;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarChart implements Chart {

	private String title;
	private List<String> xData;
	private List<Integer> yData;
	
	@Override
	public BitMap generateChart() {
		return new BitMap();

	}

}
