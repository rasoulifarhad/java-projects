package com.farhad.example.design_principles02.composite_design_pattern.simulations.motor;

import java.util.List;

public interface Node {


	void add(Node node);

	public void remove(Node node);

	List<Node> getChildren();

	public void simulate();
}
