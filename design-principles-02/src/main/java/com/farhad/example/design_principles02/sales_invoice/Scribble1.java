package com.farhad.example.design_principles02.sales_invoice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class Scribble1 extends JFrame {
	JButton btnRed = new JButton("Red");
	JButton btnGreen = new JButton("Green");
	JButton btnBlue = new JButton("Blue");
	JButton btnBlack = new JButton("Black");
	JButton btnErase = new JButton("Erase");
	JScrollBar sbrRed = new JScrollBar(JScrollBar.HORIZONTAL, 56, 1, 0, 256);
	JScrollBar sbrGreen = new JScrollBar(JScrollBar.HORIZONTAL, 128, 1, 0, 256);
	JScrollBar sbrBlue = new JScrollBar(JScrollBar.HORIZONTAL, 200, 1, 0, 256);
	JLabel labelRed = new JLabel("RED");
	JLabel labelGreen = new JLabel("GREEN");
	JLabel labelBlue = new JLabel("BLUE");
	JPanel panCanvas = new JPanel();
	JPanel panDraw = new JPanel();
	JPanel panSouth = new JPanel();
	JPanel panEast = new JPanel();
	JPanel panSouthWest = new JPanel();
	JPanel panSouthCenter = new JPanel();

	public Scribble1() {
		initGUI();
	}

	private void initGUI() {
		// set layouts
		panEast.setLayout(new GridLayout(6, 1));
		panSouth.setLayout(new BorderLayout());
		panSouthWest.setLayout(new GridLayout(3, 1));
		panSouthCenter.setLayout(new GridLayout(3, 1));
		// add to east panel
		panEast.add(btnRed);
		panEast.add(btnGreen);
		panEast.add(btnBlue);
		panEast.add(btnBlack);
		panEast.add(btnErase);
		panEast.add(panCanvas);
		// add to south west panel
		panSouthWest.add(labelRed);
		panSouthWest.add(labelGreen);
		panSouthWest.add(labelBlue);
		// add to south center panel
		panSouthCenter.add(sbrRed);
		sbrRed.setBackground(Color.red);
		panSouthCenter.add(sbrGreen);
		sbrGreen.setBackground(Color.green);
		panSouthCenter.add(sbrBlue);
		sbrBlue.setBackground(Color.blue);
		// add to south
		panSouth.add(panSouthWest, BorderLayout.WEST);
		panSouth.add(panSouthCenter, BorderLayout.CENTER);
		// add to main frame
		getContentPane().add(panDraw, BorderLayout.CENTER);
		getContentPane().add(panEast, BorderLayout.EAST);
		getContentPane().add(panSouth, BorderLayout.SOUTH);

		setSize(400, 400);
		setVisible(true);
	}

	public static void main(String[] argv) {
		Scribble1 scribble1 = new Scribble1();
	}
}