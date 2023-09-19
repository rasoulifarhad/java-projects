package com.farhad.example.design_principles02.ppp.exercise_2_srp.library;

import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.model.Patron;

public class PrintUsage {
    
	int totalDue;
	final int perPageRate = 5;
    
	public PrintUsage(Patron patron) {
		totalDue = 0;
	}
        
    public int charges() {
		return totalDue;
	}

	public void pagePrinted(PrintRecord printRecord) {
		totalDue += printRecord.getPages() * perPageRate;
	}
    
}
