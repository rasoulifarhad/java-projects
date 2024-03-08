package com.farhad.example.design_principles02.bevel_panel;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.SystemColor;

public class BevelPanel extends Panel {

	private boolean raised = true;
	private int thick = 2;
	
	public BevelPanel(boolean raised) {
		this.raised = raised;
		setBackground(SystemColor.control);
		setForeground(SystemColor.controlText);
	}

	public BevelPanel() {
		this(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int w = getSize().width -1;
		int h = getSize().height - 1;
		if (raised) {
			g.setColor(SystemColor.controlLtHighlight);
		} else {
			g.setColor(SystemColor.controlDkShadow);
		}

		for (int i = 0; i < thick; i++) {
			g.drawLine(i, i, w - i, i);
			g.drawLine(i, i, i, h - i);
		}

		if (!raised) {
			g.setColor(SystemColor.controlLtHighlight);
		} else {
			g.setColor(SystemColor.controlDkShadow);
		}

		for (int i = 0; i < thick; i++) {
			g.drawLine(w-i, i, w-i, h-i);
			g.drawLine(i, h-i, w-i, h-i);
		}

	}

	
}
