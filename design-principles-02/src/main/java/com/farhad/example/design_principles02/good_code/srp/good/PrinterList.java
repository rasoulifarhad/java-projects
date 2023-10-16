package com.farhad.example.design_principles02.good_code.srp.good;

import java.util.Vector;

public class PrinterList {
	public Vector<?> getPrinterList() {
		Vector<?> vector = null;;
		// ...
		return vector;
	}

	public synchronized void setPrinterList(Vector<?> printerList) {
		// ...
	}
	
}
