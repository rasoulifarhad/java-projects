package com.farhad.example.design_principles02.composite_design_pattern.simulations.motor;

import java.util.List;

import lombok.Getter;


public class AbstractFilterDescriptor implements FilterDescriptor {

	@Getter
	List<FilterDescriptor> children;

	public void add(FilterDescriptor fd) {
		children.add(fd);
	}

	public void remove(FilterDescriptor fd) {
		children.remove(fd);
	}

	@Override
	public void filter() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'filter'");
	}

	
}
