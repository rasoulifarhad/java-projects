package com.farhad.example.design_principles02.bevel_panel;

import java.awt.Frame;

public class CFApplication extends CloseableFrame {

	public CFApplication(String title) {
		super(title);
	}

	public static void main(String[] args) {
		Frame f = new CFApplication("Extending CloseableFrame");
		f.setVisible(true);
	}
}
