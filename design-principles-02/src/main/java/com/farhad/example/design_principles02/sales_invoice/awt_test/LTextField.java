package com.farhad.example.design_principles02.sales_invoice.awt_test;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
public class LTextField extends Panel {

	private FixedWidthLabel theLabel;
	private TextField theText;

	// A single constructor that requires a String for the field description, the number of columns to 
	// use for the TextField, and the number of columns to use for the FixedWidthLabel.
	public LTextField(String name, int size, int lwidth) {
		theLabel = new FixedWidthLabel(name, Label.RIGHT, lwidth);
		theText = new TextField(size);
		add(theLabel);
		add(theText);
	}

	public String getText() {
		return theText.getText();
	}

	public void setLabel(String newLabel) {
		theLabel.setText(newLabel);
	}
	
	private class FixedWidthLabel extends Label {
		private int columns;

		public FixedWidthLabel(String s, int align, int columns) {
			super(s, align);
			this.columns = columns;
		}

		@Override
		public Dimension getPreferredSize() {
			Dimension d = super.getPreferredSize();
			FontMetrics fm = getFontMetrics(getFont());
			int pixelPerCol = fm.charWidth('o');
			return new Dimension(pixelPerCol * columns, d.height);
		}

		
	}

}
