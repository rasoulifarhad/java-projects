package com.farhad.example.design_principles02.bevel_panel;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CloseableFrame extends Frame implements WindowListener {

	public CloseableFrame() {
		this("CloseableFrame");
	}

	public CloseableFrame(String title) {
		super(title);
		setLayout(new FlowLayout());
		addWindowListener(this);
		setSize(400, 300);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		quitApplication();
	}

	protected void quitApplication() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

}
