package com.farhad.example.design_principles02.composite_design_pattern.simulations.motor;

import java.util.List;
import java.util.Objects;

public class Component implements Node {

	List<Node> children;

	@Override
	public void add(Node node) {
		Objects.requireNonNull(node);
		children.add(node);
	}

	@Override
	public void remove(Node node) {
		Objects.requireNonNull(node);
		children.remove(node);
	}

	@Override
	public List<Node> getChildren() {
		return children;
	}

	@Override
	public void simulate() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'simulate'");
	}

}
