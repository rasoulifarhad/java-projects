package com.farhad.example.design_principles02.good_code.srp.bad;

import java.util.Vector;

import com.farhad.example.design_principles02.good_code.srp.IRawData;
import com.farhad.example.design_principles02.good_code.srp.JobEvent;
import com.farhad.example.design_principles02.good_code.srp.JobListener;
import com.farhad.example.design_principles02.good_code.srp.PrintServer;
import com.farhad.example.design_principles02.good_code.srp.ServiceAdvanced;

public class PrintServerImpl extends ServiceAdvanced implements PrintServer, JobListener {
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

	public Vector getPrinterList() {
		Vector vector = null;;
		// ...
		return vector;
	}

	public synchronized void setPrinterList(Vector printerList) {
		// ...
	}

	public void statusChanged(JobEvent jobEvent) {
		// ...
	}

	public void pageComputed(JobEvent jobEvent) {
		// ...
	}
	// ...
}
