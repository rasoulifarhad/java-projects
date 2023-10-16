package com.farhad.example.design_principles02.good_code.srp.good;

import com.farhad.example.design_principles02.good_code.srp.IRawData;

public class PrinterServerJob {

	public synchronized String createJob(Object data) {
		String str = null;
		// ...
		return str;
	}

	public int getStatus(String jobId) {
		int status = -1;
		// ...
		return status;
	}

	public void print(String jobId, int startPage, int endPage) {
		// ...
	}

	public byte[] getPreview(String jobId, int pageNum) {
		byte[] bytes = null; 
		// ...
		return bytes;
	}

	public IRawData getData(String jobId) {
		IRawData iRawData = null;
		// ...
		return iRawData;
	}

	public void abortAction(String jobId) {
		// ...
	}
	
}
