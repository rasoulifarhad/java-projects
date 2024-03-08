package com.farhad.example.design_principles02.bevel_panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;


//
// The requirements for a BevelPanel are fairly simple:
//
//- It should do everything that a regular Panel should do,and you should be able to use it any place you 
//  would normally use a regular Panel.
//- The BevelPanel varies from the built-in Panel because it adds a 3D-Border around its perimeter,which 
//  allows it to appear to stand out or sink into the surface on which it’s placed.
//- The same class should be used to create both sunken and raised BevelPanels.
public class App extends Frame {

	public App() {
		init();
	}
	private void init() {
		setLayout(new BorderLayout());
		Panel p = new BevelPanel();
		p.add(new Label("A Raised BevelPanel"));
		add(p, "South");

		p = new BevelPanel(false);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p.add(new Label("A Sunken BevelPanel"));
		add(p, "North");

		p = new Panel();
		p.setBackground(SystemColor.control);
		p.setLayout(new GridLayout(3, 3, 4, 4));
		for (int i = 0; i < 3 * 3; i++) {
			p.add(new BevelPanel((i * i) % 2 == 0));
		}
		add(p, "Center");
		setSize(600, 600);
		setVisible(true);
	}
	public static void main(String[] args) {
		App app = new App();
	}
}
